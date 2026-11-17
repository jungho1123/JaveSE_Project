package workshop.person.entity;

public class PersonEntity {
    private String name;
    private char gender;
    private String ssn;
    private String address;
    private String phone;
    public PersonEntity(){

    }
    public PersonEntity(String ssn, String name, String address, String phone) {
        setName(name);
        setSsn(ssn);
        setAddress(address);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
        // 1,3 남 2,4 여 그외 값 에러던져
        char genderNum= ssn.charAt(6);
        if (genderNum=='1'|| genderNum=='3'){
            setGender('남');
        } else if (genderNum=='2'||genderNum=='4') {
            setGender('여');

        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}



