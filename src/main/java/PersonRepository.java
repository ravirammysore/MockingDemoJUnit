public class PersonRepository implements IPersonRepository {
    public Person Get(String userName) {
        var person = new Person();
        //loads of logic here to get this guy using the database
        return person;
    }
}