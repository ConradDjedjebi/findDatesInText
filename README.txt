PURPOSE OF THIS JAVA PROGRAM:

- This JAVA program (src/com.conrad.www/Main) is responding to the following requirement :

    We want a Java program to parse any input text and extract every date it contains
    and count the dates.
    A date has to be precise, including a day, a month and a year.

    Sample text :
    ---------------------------------------------------------------------------------------------

    Marvin Lee Minsky at the Mathematics Genealogy Project; 20 May 2014
    Marvin Lee Minsky at the AI Genealogy Project. {reprint 18 September 2011)
    "Personal page for Marvin Minsky". web.media.mit.edu. Retrieved 23 June 2016.
    Admin (January 27, 2016). "Official Alcor Statement Concerning Marvin Minsky".
        Alcor Life Extension Foundation. Retrieved 2016-04-07.
    "IEEE Computer Society Magazine Honors Artificial Intelligence Leaders".
        DigitalJournal.com. August 24, 2011. Retrieved September 18, 2011.
        Press release source: PRWeb (Vocus).
    "Dan David prize 2014 winners". May 15, 2014. Retrieved May 20, 2014.

    The program would produce :

    2011:

        -08

            -24 (1)

        -09

            -18 (2)

    2014:

        -05

            -15 (1)

            -20 (2)

    2016:

        -01

            -27 (1)

        -04

            -07 (1)

        -06

            -23 (1)


RESTRICTIONS AND LIMITATIONS:

- This JAVA program do not have an IHM. Please execute the code from a CLI/IDE.
- The results are streamed to the terminal
- Date detection is limited to US locale (ISO 639 & ISO 3166 : en/US)
- Date detection is limited to the patterns shown in the Sample Text (above)

COPYRIGHT:

- This JAVA program was written from scratch by Conrad Djedjebi (24/09/2018 - 07/10/2018)
- The content of this package is not open-source and may not be used without its author's agreement
- A copy of this program was pulled to a private git and may be used as a proof of intellectual right