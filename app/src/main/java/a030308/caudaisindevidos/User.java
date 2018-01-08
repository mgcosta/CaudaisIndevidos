package a030308.caudaisindevidos;

/**
 * Created by marcia on 08-01-2018.
 */

class User {
    int _id;

    String name, email, uname,pass;

    public void setId(int id)
    {
        this._id = id;
    }

    public int getId()
    {
        return this._id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setUname(String uname)
    {
        this.uname = uname;
    }

    public String getUname()
    {
        return this.uname;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPass()
    {
        return this.pass;
    }

}
