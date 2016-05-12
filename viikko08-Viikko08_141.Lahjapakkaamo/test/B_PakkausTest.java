
import fi.helsinki.cs.tmc.edutestutils.MockInOut;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class B_PakkausTest<_Lahja, _Pakkaus> {

    private Class lahjaClass;
    private Constructor lahjaConstructor;
    private Class pakkausClass;
    private Constructor pakkausConstructor;
    String klassName = "Pakkaus";
    Reflex.ClassRef<_Pakkaus> _PakkausRef;
    Reflex.ClassRef<_Lahja> _LahjaRef;

    @Before
    public void setup() {
        _PakkausRef = Reflex.reflect("Pakkaus");
        _LahjaRef = Reflex.reflect("Lahja");

        try {
            lahjaClass = ReflectionUtils.findClass("Lahja");
            lahjaConstructor = ReflectionUtils.requireConstructor(lahjaClass, String.class, int.class);

            pakkausClass = ReflectionUtils.findClass("Pakkaus");
            pakkausConstructor = ReflectionUtils.requireConstructor(pakkausClass);

        } catch (Throwable t) {
        }
    }

    @Test
    @Points("141.2")
    public void luokkaJulkinen() {
        assertTrue("Luokan " + klassName + " pitää olla julkinen, eli se tulee määritellä\npublic class " + klassName + " {...\n}", _PakkausRef.isPublic());
    }

    @Test
    @Points("141.2")
    public void eiYlimaaraisiaMuuttujia() {
        saniteettitarkastus(klassName, 1, "lahjat tallettava lista. Voit laskea painon käymällä lahjat läpi!");
    }

    @Test
    @Points("141.2")
    public void testaaPakkausKonstruktori() throws Throwable {
        Reflex.MethodRef0<_Pakkaus, _Pakkaus> ctor = _PakkausRef.constructor().takingNoParams().withNiceError();
        assertTrue("Määrittele luokalle " + klassName + " julkinen konstruktori: public " + klassName + "()", ctor.isPublic());
        String v = "virheen aiheutti koodi new Pakkaus();";
        ctor.withNiceError(v).invoke();
    }

    public _Pakkaus luoPakkaus() throws Throwable {
        return _PakkausRef.constructor().takingNoParams().withNiceError().invoke();
    }

    public _Lahja luoLahja(String nimi, int paino) throws Throwable {
        return _LahjaRef.constructor().taking(String.class, int.class).withNiceError().invoke(nimi, paino);
    }

    @Test
    @Points("141.2")
    public void lisaaLahjaMetodi() throws Throwable {
        _Lahja lahja = luoLahja("kirja", 1);
        _Pakkaus pakkaus = luoPakkaus();

        String v = "\nLahja t = new Lahja(\"kirja\",1); \n"
                + "Pakkaus m = new Pakkaus();\n"
                + "m.lisaaLahja(t);";

        assertTrue("Luokalla Pakkaus tulee olla metodi public void lisaaLahja(Lahja lahja)", _PakkausRef.method(pakkaus, "lisaaLahja").returningVoid().taking(_LahjaRef.cls()).withNiceError(v).isPublic());

        _PakkausRef.method(pakkaus, "lisaaLahja").returningVoid().taking(_LahjaRef.cls()).withNiceError(v).invoke(lahja);
    }

    @Test
    @Points("141.2")
    public void tarkistaLisaaLahjanToiminta() {
        try {
            Object pakkaus = ReflectionUtils.invokeConstructor(pakkausConstructor);

            Method lisaaLahjaMeto = ReflectionUtils.requireMethod(pakkausClass, "lisaaLahja", ReflectionUtils.findClass("Lahja"));

            Object tiili = ReflectionUtils.invokeConstructor(lahjaConstructor, "Tiili", 8);
            Object hammas = ReflectionUtils.invokeConstructor(lahjaConstructor, "Hammas", 8);
            ReflectionUtils.invokeMethod(void.class, lisaaLahjaMeto, pakkaus, tiili);
            ReflectionUtils.invokeMethod(void.class, lisaaLahjaMeto, pakkaus, hammas);

            List<Object> lahjat = (List<Object>) oliomuuttujaLista(pakkausClass, pakkaus);
            if (!lahjat.contains(tiili)) {
                fail("asd");
            }

            if (!lahjat.contains(hammas)) {
                fail("asd");
            }

        } catch (Throwable t) {
            junit.framework.Assert.fail("Tarkista että Pakkaus-luokan metodi lisaaLahja lisää tavaroita pakkaukseen. Onhan luokalle määritelty myös ArrayList, joka on alustettu?");
        }
    }
    
    private boolean sisaltaa(String palautus, String... oletetutArvot) {
        for (String arvo : oletetutArvot) {
            if (!palautus.contains(arvo)) {
                return false;
            }
        }

        return true;
    }

    private Object oliomuuttujaLista(Class clazz, Object container) {
        for (Field f : clazz.getDeclaredFields()) {
            if (f.getType().equals(List.class)) {
                f.setAccessible(true);
                try {
                    return f.get(container);
                } catch (IllegalArgumentException ex) {
                } catch (IllegalAccessException ex) {
                }
            }

            if (f.getType().equals(ArrayList.class)) {
                f.setAccessible(true);
                try {
                    return f.get(container);
                } catch (IllegalArgumentException ex) {
                } catch (IllegalAccessException ex) {
                }
            }

            if (f.getType().equals(LinkedList.class)) {
                f.setAccessible(true);
                try {
                    return f.get(container);
                } catch (IllegalArgumentException ex) {
                } catch (IllegalAccessException ex) {
                }
            }
        }

        return null;
    }

    private void saniteettitarkastus(String klassName, int n, String m) throws SecurityException {
        Field[] kentat = ReflectionUtils.findClass(klassName).getDeclaredFields();

        for (Field field : kentat) {
            assertFalse("et tarvitse \"stattisia muuttujia\", poista luokalta " + klassName + " muuttuja " + kentta(field.toString(), klassName), field.toString().contains("static") && !field.toString().contains("final"));
            assertTrue("luokan kaikkien oliomuuttujien näkyvyyden tulee olla private, muuta luokalta " + klassName + " löytyi: " + kentta(field.toString(), klassName), field.toString().contains("private"));
        }

        if (kentat.length > 1) {
            int var = 0;
            for (Field field : kentat) {
                if (!field.toString().contains("final")) {
                    var++;
                }
            }
            assertTrue("et tarvitse " + klassName + "-luokalle kuin " + m + ", poista ylimääräiset", var <= n);
        }
    }

    private String kentta(String toString, String klassName) {
        return toString.replace(klassName + ".", "").replace("java.lang.", "").replace("java.util.", "");
    }
}
