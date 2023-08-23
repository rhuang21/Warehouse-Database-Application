package ca.ubc.cs304.entities;

public class CustomerEntity {

    private final int CustomerID;
    private final String Name;
    private final String Email;
    private final int Phone;
    private final String Postal;
    private final String Country;
    private final String City;
    private final String Province;

    public CustomerEntity(int CustomerID, String name, String email, int phone,
                          String postal, String country, String city, String province) {
        this.CustomerID = CustomerID;
        this.Name = name;
        this.Email = email;
        this.Phone = phone;
        this.Postal = postal;
        this.Country = country;
        this.City = city;
        this.Province = province;
    }

    public int getCustomerID(){
        return CustomerID;
    }
    public String getName(){
        return Name;
    }

    public String getEmail(){
        return Email;
    }

    public int getPhone(){
        return Phone;
    }
    public String getPostal(){
        return Postal;
    }
    public String getCountry(){
        return Country;
    }
    public String getCity(){
        return City;
    }
    public String getProvince(){
        return Province;
    }

}
