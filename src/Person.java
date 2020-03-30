import java.util.Comparator;

class Person
        implements Comparable<Person>{

    //deklaracja atrybutow z wartosciami domyslnymi
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //konstruktor zwykly
    public Person(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Person(long a){
        Object obj = (Object)a;
        this.phoneNumber = obj.toString();
    }

    public Person(Object obj) {
        String str = obj.toString();
        String strParts[] = str.split("[  ;]", 3);
        this.firstName = strParts[0];
        this.lastName = strParts[1];
        this.phoneNumber = strParts[2];
    }

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //methods
    public String toString()
    {
        return getFirstName() + " " + getLastName() + " " + getPhoneNumber();
    }

    //Comparable
    public int compareTo(Person person){
        int result = String.CASE_INSENSITIVE_ORDER.compare(lastName, person.getLastName());
        if (result == 0)
            result = String.CASE_INSENSITIVE_ORDER.compare(firstName, person.getFirstName());
        if (result == 0)
            result = String.CASE_INSENSITIVE_ORDER.compare(phoneNumber, person.getPhoneNumber());
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = super.clone();
        return o;
    }

    //Comparator
    public static Comparator<Person> lastNameComparator = new Comparator<Person>()
    {
        @Override
        public int compare(Person o1, Person o2) {
            int porownaniePoNazwisku = o1.getLastName().compareTo(o2.getLastName());
            if (porownaniePoNazwisku != 0) {
                return porownaniePoNazwisku;
            }
            int porownaniePoImieniu = o1.getFirstName().compareTo(o2.getFirstName());
            if (porownaniePoImieniu != 0) {
                return porownaniePoImieniu;
            }
            String o1Wiek = o1.getPhoneNumber();
            return o1Wiek.compareTo(o2.getPhoneNumber());
        }
    };

    public static Comparator<Person> firstNameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            int porownaniePoImieniu = o1.getFirstName().compareTo(o2.getFirstName());
            if (porownaniePoImieniu != 0) {
                return porownaniePoImieniu;
            }

            int porownaniePoNazwisku = o1.getLastName().compareTo(o2.getLastName());
            if (porownaniePoNazwisku != 0) {
                return porownaniePoNazwisku;
            }

            String o1Wiek = o1.getPhoneNumber();
            return o1Wiek.compareTo(o2.getPhoneNumber());
        }
    };

    public static Comparator<Person> ageComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            int porownaniePoWieku = o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
            if (porownaniePoWieku != 0){
                return porownaniePoWieku;
            }
            int porownaniePoNazwisku = o1.getLastName().compareTo(o2.getLastName());
            if (porownaniePoNazwisku != 0) {
                return porownaniePoNazwisku;
            }

            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    };

}

