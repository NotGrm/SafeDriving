//  DEFINIR LES ORNEMENTS (SET ARRAYS)
var day_of_week = new Array('Dim','Lun','Mar','Mer','Jeu','Ven','Sam');
var month_of_year = new Array('Janvier','Fevrier','Mars','Avril','Mai','Juin','Juillet','Aout','Septembre','Octobre','Novembre','Decembre');

//  DECLARER ET INITIALISER DES VARIABLES
var Calendar = new Date();

var year = Calendar.getYear();	    // Returns year
var month = Calendar.getMonth();    // Returns month (0-11)
var today = Calendar.getDate();    // Returns day (1-31)
var weekday = Calendar.getDay();    // Returns day (1-31)

var DAYS_OF_WEEK = 7;    // "constant" pour le nombre du jour dans la semaine
var DAYS_OF_MONTH = 31;    // "constant" pour le nombre du jour dans le mois
var cal;    // UTILISER POUR IMPRIMER

Calendar.setDate(1);    // commencer le calendrier avec le jour a  '1'
Calendar.setMonth(month);    // commencer le mois du calendrier avec le mois actuel


/* LES VARIABLES POUR FORMATER
NOTE: TU PEUX FORMATER LE 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
      les étiquettes pour personnaliser le regard de votre calendrier. */

var TR_start = '<TR>';
var TR_end = '</TR>';
var highlight_start = '<TD WIDTH="30"><TABLE CELLSPACING=0 BORDER=1 BGCOLOR=DEDEFF BORDERCOLOR=CCCCCC><TR><TD WIDTH=20><B><CENTER>';
var highlight_end   = '</CENTER></TD></TR></TABLE></B>';
var TD_start = '<TD WIDTH="30"><CENTER>';
var TD_end = '</CENTER></TD>';

/* COMMENCER LE CODE POUR LE CALENDRIER
NOTE: Vous pouvez formater CEUX CI 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
les étiquettes pour personnaliser le regard de votre calendrier.*/

cal =  '<TABLE BORDER=1 CELLSPACING=0 CELLPADDING=0 BORDERCOLOR=BBBBBB><TR><TD>';
cal += '<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=2>' + TR_start;
cal += '<TD COLSPAN="' + DAYS_OF_WEEK + '" BGCOLOR="#EFEFEF"><CENTER><B>';
cal += month_of_year[month]  + '   ' + year + '</B>' + TD_end + TR_end;
cal += TR_start;

//   Ne PAS EDITER AU DESSOUS DE CE POINT  //

// LES BOUCLES POUR CHAQUE JOUR DE LA SEMAINE
for(index=0; index < DAYS_OF_WEEK; index++)
{ 

    // LE JOUR HARDI (VIF), LE JOUR ACTUEL DE LA SEMAINE(LE JOUR D'AUJOURD'HUI LE FAIRE VIF)
    if(weekday == index)
        cal += TD_start + '<B>' + day_of_week[index] + '</B>' + TD_end;

    // IMPRIMER LE JOUR 
    else
        cal += TD_start + day_of_week[index] + TD_end;
}

cal += TD_end + TR_end;
cal += TR_start;

// REMPLIR DES ECARTS BLANCS JUSQU' AU JOUR D'AUJOURD'HUI
for(index=0; index < Calendar.getDay(); index++)
    cal += TD_start + '  ' + TD_end;

// LES BOUCLES POUR CHAQUE JOUR DANS LE CALENDRIER
for(index=0; index < DAYS_OF_MONTH; index++)
{
    if( Calendar.getDate() > index )
    {
        // RETOURNE SUR LE LENDEMAIN POUR IMPRIMER
        week_day =Calendar.getDay();

        // COMMENCER LE NOUVEAU RANG POUR LE PREMIER JOUR DE LA SEMAINE
        if(week_day == 0)
            cal += TR_start;

        if(week_day != DAYS_OF_WEEK)
        {

            // REGLER LA VARIABLE DANS LA BOUCLE POUR GRADUER JUSQU'AU BUTS
            var day  = Calendar.getDate();

            // SOULIGNER LA DATE D'AUJOURD'HUI
            if( today==Calendar.getDate() )
                cal += highlight_start + day + highlight_end + TD_end;

            // IMPRIMER LE JOUR
            else
                cal += TD_start + day + TD_end;
        }

        // TERMINER LE RANG POUR LE DERNIER JOUR DE LA SEMAINE
        if(week_day == DAYS_OF_WEEK)
            cal += TR_end;
    }

    // LES GRADUATIONS JUSQU' A LA FIN DU MOIS
    Calendar.setDate(Calendar.getDate()+1);

}// end for loop

cal += '</TD></TR></TABLE></TABLE>';

//  IMPRIMER LE CALENDRIER
document.write(cal);