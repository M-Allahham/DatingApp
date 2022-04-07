package com.barhop.datingapp;

public class Profile {

    public String name;
    public String photoURL;
    public int age;
    public int elo;
    public String bio;

    public Profile(String Name, String PhotoURL, String Bio, int Age, int Elo){
        name = Name;
        photoURL = PhotoURL;
        age = Age;
        elo = Elo;
        bio = Bio;
    }

    // These profiles can be extracted from a database, using a filter to check for elo
    public static Profile truman = new Profile("Truman Smith", "https://media-exp1.licdn.com/dms/image/C4D03AQH_eldktTVqAQ/profile-displayphoto-shrink_200_200/0/1648720224049?e=1654732800&v=beta&t=Du-qfs09r4QY4rW35cR2fV2pyLFGR51ODz0CoYntHqU","", 21, 1000);
    public static Profile malik = new Profile("Malik Allahham", "https://media-exp1.licdn.com/dms/image/C5603AQGnvauBapUMRg/profile-displayphoto-shrink_100_100/0/1648854603894?e=1654732800&v=beta&t=ScPUSbpHyL28eHhCNHLSa-uE1masnMJ81tOMR83lGyo", "",22, 1000);
    public static Profile branden = new Profile("Branden Talbert", "https://media-exp1.licdn.com/dms/image/C4E03AQE64hifVdzCfQ/profile-displayphoto-shrink_100_100/0/1597281437949?e=1654732800&v=beta&t=uPArtxBPEE8NBUXYzHz_JVm99KccbmT5hagHeVOBQt0", "",21, 1000);
    public static Profile anna = new Profile("Anna Scott", "https://media-exp1.licdn.com/dms/image/C4E03AQEil9jLookOsQ/profile-displayphoto-shrink_100_100/0/1611948096798?e=1654732800&v=beta&t=F2pgkdaCAu2nuIQ2miVxGRP9SAT9S8D_vGcAeaj3yvE", "",22,1000);
    public static Profile truman1 = new Profile("Trumane Smith", "https://media-exp1.licdn.com/dms/image/C4D03AQH_eldktTVqAQ/profile-displayphoto-shrink_200_200/0/1648720224049?e=1654732800&v=beta&t=Du-qfs09r4QY4rW35cR2fV2pyLFGR51ODz0CoYntHqU","", 21, 1000);
    public static Profile malik1 = new Profile("Maleek Allahham", "https://media-exp1.licdn.com/dms/image/C5603AQGnvauBapUMRg/profile-displayphoto-shrink_100_100/0/1648854603894?e=1654732800&v=beta&t=ScPUSbpHyL28eHhCNHLSa-uE1masnMJ81tOMR83lGyo", "",22, 1000);
    public static Profile branden1 = new Profile("Brandoon Talbert", "https://media-exp1.licdn.com/dms/image/C4E03AQE64hifVdzCfQ/profile-displayphoto-shrink_100_100/0/1597281437949?e=1654732800&v=beta&t=uPArtxBPEE8NBUXYzHz_JVm99KccbmT5hagHeVOBQt0", "",21, 1000);
    public static Profile anna1 = new Profile("Annnnna Scott", "https://media-exp1.licdn.com/dms/image/C4E03AQEil9jLookOsQ/profile-displayphoto-shrink_100_100/0/1611948096798?e=1654732800&v=beta&t=F2pgkdaCAu2nuIQ2miVxGRP9SAT9S8D_vGcAeaj3yvE", "",22,1000);

    // Compile list from database
    public static Profile[] profiles = {truman, malik, anna, branden, truman1, malik1, anna1, branden1};

}
