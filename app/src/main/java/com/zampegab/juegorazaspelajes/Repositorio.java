package com.zampegab.juegorazaspelajes;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Repositorio {
    private static List<Caballo> caballos;
    private static List<CaballoCruza> caballosCruzas;
    private static String voz;

    private static List<Caballo> hardcodeCaballos(){
        List<Caballo> retorno = new ArrayList<>();
        retorno.add(new Caballo(1,"angola","Sangre pura de carrera","Zaino colorado",R.drawable.angola_spc_zainocolorado,R.raw.pelaje_zaino_colorado,R.raw.raza_spc,R.raw.razaconpelaje_spc_zaina_colorada, "Raza de Caballos con orígen el siglo XVIII en Inglaterra cuando yeguas madres inglesas fueron cruzadas con sementales árabes importados para crear corredores de distancia. Los pura sangre se destacan como caballos de carrera pero también se utilizan como caballos de equitación y otros entrenamientos ecuestres combinados, debido a su gran  condición atlética.\n" +
                "El color de capa más común es el castaño pero también puede ser Zaino, Alazán o Tordillo en cuanto a su pelaje.\n"));
        retorno.add(new Caballo(2,"Candelaria","Mestizo","Tobiano",R.drawable.candelaria_mestizo_tobiano,R.raw.pelaje_tobiano,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_tobiano,"Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Capa caracterizada por manchas de bordes definidos blancas –grandes o pequeñas- que, generalmente, se inician sobre la parte dorsal."));
        retorno.add(new Caballo(3,"Ciro","Mestizo","Tordillo canela",R.drawable.ciro_mestizo_tordillocanela,R.raw.pelaje_tordillo_canela,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_tordillo_canela,"Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Se caracteriza por poseer pelos blancos y negros entremezclados, lo cual le da a la capa un aspecto grisáceo que puede variar del gris oscuro al casi blanco."));
        retorno.add(new Caballo(4,"Bionda","Mestizo","Alazan ruano",R.drawable.bionda_mestizo_alazanruano,R.raw.pelaje_alazan_ruano,R.raw.raza_mestizo ,R.raw.razaconpelaje_mestizo_alazan_ruano,"Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia."));
        retorno.add(new Caballo(5,"Bonita","Mestizo","Overo azulejo",R.drawable.bonita_mestizo_criollo_overo_azulejo,R.raw.pelaje_overo_azulejo,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_cuartodemilla_overo_azulejo,"RAZA MESTIZO - Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia."));
        retorno.add(new Caballo(7,"Juana","Cuarto de milla","Bayo",R.drawable.juana_cuartodemilla_bayo,R.raw.pelaje_bayo,R.raw.raza_cuartodemilla,R.raw.razaconpelaje_cuartodemilla_bayo,"Raza de Caballos conformada por la cruza de Pura Sangre Inglés y Mustang americano. De carácter tranquilo; es muy sensible y sociable. Veloces, dúctiles, de poca estatura y corpulentos: constitución musculosa, pecho grande y ancho.\n" +
                "Muy amplia es la gama de pelaje, sólo no se aceptan los Pintados, los Manchados (Appaloosa) ni los Albinos.\n"));
        retorno.add(new Caballo(8,"Amapola","Petiso argentino","Rosillo",R.drawable.amapola_petiso_argentino_rosillo,R.raw.pelaje_rosillo,R.raw.raza_petiso_argentino,R.raw.razaconpelaje_petizo_argentino_rosillo, "Raza de Caballos que nació de la cruza de petisos importados con caballos de otras razas, principalmente autóctonas. De cabeza mediana, orejas pequeñas, cuerpo armonioso y profundo; de acción ágil y suelta, temperamento activo y brioso.En la actualidad, se usa para actividades hípicas con niños y niñas. Formado por una capa de pelos rojizos y blancos entremezclados, generalmente, sobre piel clara."));
        retorno.add(new Caballo(9,"Ambar","Mestizo","Alazan tostado",R.drawable.ambar_mestizo_cruza_arabe_alazan_tostado,R.raw.pelaje_alazan_tostado,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_cruza_arabe_alazan_tostado, "RAZA MESTIZO - Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia"));
        retorno.add(new Caballo(10,"Antu","Mestizo","Oveiro zaino",R.drawable.antu_mestizo_overo_zaino,R.raw.pelaje_overo_zaino,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_overo_zaino, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia."));
        retorno.add(new Caballo(11,"Blanco","Mestizo","Blanco",R.drawable.blanco_mestizo_blanco,R.raw.pelaje_blanco,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_blanco, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Formado por pelos de ese color y piel que carece de pigmentación."));
        retorno.add(new Caballo(12,"Cacique","Mestizo","Alazan",R.drawable.cacique_mestizo_alazan,R.raw.pelaje_alazan,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_alazan, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Capa color anaranjado parejo y uniforme, que va del amarillento al colorado azafrán. Su piel es oscura. Las crines, cerdas y miembros son del mismo color o más claros, pero nunca oscuro, pero nunca negras."));
        retorno.add(new Caballo(13,"Felipe","Mestizo","Zaino",R.drawable.felipe_mestizo_zaino,R.raw.pelaje_zaino,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_zaino, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. La capa tiene un color fundamentalmente marrón, variables de un rojo al negro."));
        //retorno.add(new Caballo(14,"Huaflin","Criollo","Horsepicaso",R.drawable.huaflin_criollo_horespicaso,R.raw.pelaje_horsepicaso,R.raw.raza_criollo,R.raw.nohayaudio, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Se caracteriza por capa oscura con frente y extremidades blancas."));
        //retorno.add(new Caballo(15,"Mora","Petiso argentino","Tordillo moro",R.drawable.mora_petiso_argentino_tordillo_moro,R.raw.pelaje_tordillo,R.raw.raza_petizo_argentino,R.raw.nohayaudio, "Raza de Caballos que nació de la cruza de petisos importados con caballos de otras razas, principalmente autóctonas. De cabeza mediana, orejas pequeñas, cuerpo armonioso y profundo; de acción ágil y suelta, temperamento activo y brioso.En la actualidad, se usa para actividades hípicas con niños y niñas. Se caracteriza por poseer pelos blancos y negros entremezclados, lo cual le da a la capa un aspecto grisáceo que puede variar del gris oscuro al casi blanco."));
        retorno.add(new Caballo(16,"Muñeco","Mestizo","Overo rosado",R.drawable.muneco_mestizo_overo_rosado,R.raw.pelaje_overo_rosado,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_overo_rosado, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Capa pigmentada con manchas blancas características por sus bordes irregulares e indefinidos. Se da tanto en una capa pigmentada con manchas blancas o al revés. La parte inferior del cuerpo suele tener más presencia de blanco que la parte superior."));
        retorno.add(new Caballo(17,"Nala","Mestizo","Moro",R.drawable.nala_mestizo_moro,R.raw.pelaje_moro,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_moro, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Formado por capa de color gris azulina, formada pelos negros y blancos sobre piel negra. Su cabeza es más bien oscura."));
        retorno.add(new Caballo(18,"Pamperito","Petiso argentino","Zaino",R.drawable.pamperito_petiso_argentino_zaino,R.raw.pelaje_zaino,R.raw.raza_petiso_argentino,R.raw.razaconpelaje_petizo_argentino_zaino, "Raza de Caballos que nació de la cruza de petisos importados con caballos de otras razas, principalmente autóctonas. De cabeza mediana, orejas pequeñas, cuerpo armonioso y profundo; de acción ágil y suelta, temperamento activo y brioso.En la actualidad, se usa para actividades hípicas con niños y niñas. La capa tiene un color fundamentalmente marrón, variables de un rojo al negro."));
        retorno.add(new Caballo(19,"Pintada","Mestizo","Alazan pintado",R.drawable.pintada_mestizo_alazan_pintado,R.raw.pelaje_alazan_pintado,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_alazan_pintado, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Capa color rojizo de distintos tonos que presenta matices yendo del claro al oscuro.  Es distinguida porque los pelos de diferentes colores se agrupan formando manchas o parches."));
        retorno.add(new Caballo(20,"Pochito","Mestizo","Zaino",R.drawable.pochito_mestizo_zaino,R.raw.pelaje_zaino,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_zaino, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. La capa tiene un color fundamentalmente marrón, variables de un rojo al negro."));
        retorno.add(new Caballo(21,"Primavera","Silla argentino","Alazan",R.drawable.primavera_silla_argentino_alazan,R.raw.pelaje_alazan,R.raw.raza_silla_argentino,R.raw.razaconpelaje_silla_argentino_alazan, "Raza de Caballo cuyo orígen se remonta a 1941 cuando  el Anglo Argentino se transformó en raza para la AAFE (Asociación Argentina de Fomento Equino). A partir de 1982 comenzó a llamarse Silla Argentino. Es una animal muy parecido al SPC, aunque más robustos. Se destaca por su temperamento enérgico y vivaz. De volumen y peso medianos, su estructura fuerte y proporcionada le otorga una armonía apta para el deporte. \n" +
                "Su pelaje, notablemente liso y sedoso, puede ser Alazán, Zaino o Tordillo pero no Pintado o Tobiano.\nCapa color anaranjado parejo y uniforme, que va del amarillento al colorado azafrán. Su piel es oscura. Las crines, cerdas y miembros son del mismo color o más claros, pero nunca oscuro, pero nunca negras."));
        //retorno.add(new Caballo(22,"Tigre","Criollo","Bayo gateado",R.drawable.tigre_criollo_bayo_gateado,R.raw.pelaje_bayo_gateado,R.raw.raza_criollo,R.raw.razaconpelaje_criollo_gateado, "Raza de Caballos propio de Latinoamérica. Son animales de cuerpo robusto y musculoso, con unas extremidades fuertes y una abundante melena; de porte equilibrado, armónico y con el centro de gravedad bajo. De carácter autónomo y perseverante.\n" +
             //   "No se aceptan en esta raza pelajes Tobiano o Pintado. El color de la capa es amarilla anaranjada con distintas tonalidades. Se caracteriza por presentar raya de mula (línea que corre desde la cruz hasta la cola, de color más intenso que el resto del pelaje) y cebraduras (franjas transversales de color más oscuro que se encuentran en los miembros)."));
        retorno.add(new Caballo(23,"Tupac","Mestizo","Zaino oscuro",R.drawable.tupac_mestizo_zaino_oscuro,R.raw.pelaje_zaino_oscuro,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_zaino_oscuro, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. La capa tiene un color fundamentalmente marrón, variables de un rojo al negro."));
        retorno.add(new Caballo(24,"Zorzal","Mestizo","Tordillo",R.drawable.zorzal_mestizo_tordillo,R.raw.pelaje_tordillo,R.raw.raza_mestizo,R.raw.razaconpelaje_mestizo_tordillo, "Cuando el resultado de la cruza entre dos caballos resulta en otro cuyas características no corresponden a ninguna raza pura conocida, se lo denomina CABALLO MESTIZO. Su pelaje depende mucho de las cruzas y los genes que tenga el caballo, por lo que podemos decir que la gama de colores y combinaciones con la que cuentan en su pelaje es verdaderamente muy amplia. Se caracteriza por poseer pelos blancos y negros entremezclados, lo cual le da a la capa un aspecto grisáceo que puede variar del gris oscuro al casi blanco."));
        return retorno;
    }

    public static List<CaballoCruza> harcodeCaballosCruza(){
        List<CaballoCruza> retorno = new ArrayList<>();
        retorno.add(new CaballoCruza(1,"bella",R.drawable.bella,"apapaloosa","bonita", R.drawable.bella_padres));
        retorno.add(new CaballoCruza(2,"huayra",R.drawable.huayra, "apapaloosa", "pocha", R.drawable.huayra_padres));
        retorno.add(new CaballoCruza(3,"mancha",R.drawable.mancha, "apapaloosa", "pintada", R.drawable.mancha_padres));
        retorno.add(new CaballoCruza(4, "nalito",R.drawable.nalito, "silla argentino", "nala", R.drawable.nalito_padres));
        retorno.add(new CaballoCruza(5, "orita", R.drawable.orita, "alazan tostado", "petra", R.drawable.orita_padres));
        retorno.add(new CaballoCruza(6, "pirata", R.drawable.pirata, "tobiano", "kika", R.drawable.pirata_padres));
        return retorno;
    }

    public static List<CaballoCruza> getCaballosCruza(){
        if(caballosCruzas == null){
            caballosCruzas = harcodeCaballosCruza();
        }
        Collections.shuffle(caballosCruzas);
        return caballosCruzas;
    }
    public static List<Caballo> getCaballos(){
        if(caballos == null){
            caballos = hardcodeCaballos();
        }
        Collections.shuffle(caballos);
        return caballos;
    }

    public static List<CaballoCruza> getCaballosCruzaRandom(int cantidad){
        List<CaballoCruza> var_caballos_cruza = getCaballosCruza();
        List<CaballoCruza> retorno = new ArrayList<>();
        int max = getCaballosCruza().size() -1;
        for (int i = 0; i < cantidad; i++) {
            int random = (int)(Math.random()*max);
            retorno.add(var_caballos_cruza.get(random));
            var_caballos_cruza.remove(random);
            max--;
        }
        caballosCruzas = null;
        return retorno;
    }




    public static List<Caballo> getCaballosRandom(int cantidad){
        List<Caballo> var_caballos = getCaballos();
        List<Caballo> retorno = new ArrayList<>();
        int max = getCaballos().size() -1;
        for (int i = 0; i < cantidad; i++) {
            int random = (int)(Math.random()*max);
            retorno.add(var_caballos.get(random));
            var_caballos.remove(random);
            max--;
        }
        caballos = null;
        return retorno;
    }

    public static Caballo findCaballoBy(String by, Object str_filtro){
        Caballo caballo = null;
        switch (by){
            case "raza":
                return findCaballoByRaza((String)str_filtro);
            case "pelaje":
                return findCaballoByPelaje((String)str_filtro);
            case "raza_pelaje":
                return findCaballoByRazaPelaje((String)str_filtro);
            case "str_img":
                return findCaballoByimg((int)str_filtro);
            case "str_audio_pelaje":
                return findCaballoByStrAudioPelaje((int)str_filtro);
            case "str_audio_raza":
                return findCaballoByStrAudioRaza((int)str_filtro);
            case "str_audio_raza_pelaje":
                return findCaballoByStrAudioRazaPelaje((int)str_filtro);
        }
        return caballo;
    }

    private static Caballo findCaballoByRaza(String raza){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getRaza() == raza){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByPelaje(String pelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getPelaje() == pelaje){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByRazaPelaje(String razapelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getRaza()+c.getPelaje() == razapelaje){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByimg(int img){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getImg() == img){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioPelaje(int audio_pelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getAudio_pelaje(voz) == audio_pelaje){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioRaza(int audio_raza){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getAudio_raza(voz) == audio_raza){
                caballo = c;
            }
        }
        return caballo;
    }

    private static Caballo findCaballoByStrAudioRazaPelaje(int audio_raza_pelaje){
        Caballo caballo = null;
        for (Caballo c: getCaballos()) {
            if(c.getAudio_raza_pelaje(voz) == audio_raza_pelaje){
                caballo = c;
            }
        }
        return caballo;
    }

}
