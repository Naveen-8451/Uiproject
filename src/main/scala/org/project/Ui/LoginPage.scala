package org.project.Ui

import scala.swing._
import java.time.Year
import scala.util.matching.Regex
import java.sql.DriverManager
import java.sql.Connection
import java.util.Calendar
import java.text.SimpleDateFormat
import org.apache.hadoop._

//import javafx.scene.control.ComboBox

object LoginPage extends App
{
  val frame = new MainFrame
  {
    
//    def movielist
//    {
//     
//      val driver = "com.mysql.jdbc.Driver"
//      val url = "jdbc:mysql://localhost/sample2?autoReconnect=true&useSSL=false"
//      val uname = "scott"
//      val pwd = "tiger" // there's probably a better way to do this
//      var connection: Connection = null
//      try
//      {
//        Class.forName(driver)
//        connection = DriverManager.getConnection(url, uname, pwd)
//        val statement = connection.createStatement()
//        
//        val res = statement.executeQuery("select name from movielist where genre ='Action'")
//        var dm1 = List[String]()
//        while(res.next())
//        {
//          val b = res.getString("name")
//          println(b)
//          if (b.length() != 0) { dm1 = b :: dm1 }
//            val movieList = new ComboBox(dm1)
//            contents = new BoxPanel(Orientation.Horizontal)
//            {
//              border = Swing.TitledBorder(Swing.LineBorder(java.awt.Color.BLUE), "Movie Genre")
//              contents += Swing.HStrut(15)
//              contents += new Label("MovieList")
//              contents += Swing.HStrut(15) 
//              contents += movieList
//            }
//        }
//      }
//      catch
//      {
//        case e => e.printStackTrace
//      }
//      connection.close()
//    }
    def welcome
    {

      title = "Movie Selection"
      var dm = List[String]()
      var dm1 = List[String]()
      //val genre = new ComboBox(dm)
      val driver = "com.mysql.jdbc.Driver"
      val url = "jdbc:mysql://localhost/sample2?autoReconnect=true&useSSL=false"
      val uname = "scott"
      val pwd = "tiger" // there's probably a better way to do this
      var connection: Connection = null
      try
      {
        Class.forName(driver)
        connection = DriverManager.getConnection(url, uname, pwd)
        val statement = connection.createStatement()
        val res = statement.executeQuery("SELECT name FROM genre")
        //val genre = new ComboBox(dm)
        while (res.next())
        {
          val b = res.getString("name")
          if (b.length() != 0) { dm = b :: dm }
          val genre = new ComboBox(dm)
          contents = new BoxPanel(Orientation.Vertical)
          {
            contents += new BoxPanel(Orientation.Horizontal)
            {
              contents += Swing.HStrut(15)
              contents += new Label("Movie genre")
              contents += Swing.HStrut(15)
              contents += genre
            }
            border = Swing.TitledBorder(Swing.LineBorder(java.awt.Color.BLUE), "Movie Genre")
            contents += new BoxPanel(Orientation.Horizontal)
            {
              contents += new Button(Action("Show Movies")
              {
                  movielist
                    def movielist
                    {
                    
                        val driver = "com.mysql.jdbc.Driver"
                        val url = "jdbc:mysql://localhost/sample2?autoReconnect=true&useSSL=false"
                        val uname = "scott"
                        val pwd = "tiger" // there's probably a better way to do this
                        var connection: Connection = null
                        Class.forName(driver)
                        connection = DriverManager.getConnection(url, uname, pwd)
                        val statement = connection.createStatement() 
                        val res = statement.executeQuery("select name from movielist where genre ='"+genre.item+"'")
                        var dm1 = List[String]()
                        while(res.next())
                        {
                          val b = res.getString("name")
                          println(b)
                          
                          if(b.length() != 0) { dm1 = b :: dm1 }
                        }
                        val movieList = new ComboBox(dm1)
                        if( genre.item.equals("Action")||genre.item.equals("Adventure")||genre.item.equals("Animation")||genre.item.equals("Childern")||
                        genre.item.equals("Comedy")||genre.item.equals("Crime")||genre.item.equals("Documentary")||genre.item.equals("Drama")||
                        genre.item.equals("Fantasy")||genre.item.equals("Film-Noir")||genre.item.equals("Horror")||genre.item.equals("Musical")||
                        genre.item.equals("Mystery")||genre.item.equals("Romance")||genre.item.equals("Sci-Fi")||genre.item.equals("Thriller")||
                        genre.item.equals("War")||genre.item.equals("Western"))
                        {
                          
                          contents += new BoxPanel(Orientation.Horizontal)
                          {
                            border = Swing.TitledBorder(Swing.LineBorder(java.awt.Color.BLUE), "Movie Genre")
                            contents += Swing.HStrut(15)
                            contents += new Label("MovieList")
                            contents += Swing.HStrut(15) 
                            contents += movieList
                            
                          }
                        }
                        
                    }
                })
              
            }
          } 
        }
              
      } 
      catch
      {
        case e => e.printStackTrace
      }
      connection.close()
      size = new Dimension(300, 200)
      centerOnScreen()

  }

    def signin {

      val driver = "com.mysql.jdbc.Driver"
      val url = "jdbc:mysql://localhost/sample2?autoReconnect=true&useSSL=false"
      val uname = "scott"
      val pwd = "tiger"

      // there's probably a better way to do this
      var connection: Connection = null

      try {
        // make the connection
        Class.forName(driver)
        connection = DriverManager.getConnection(url, uname, pwd)
        //val u_name = username.peer.getText
        //val p_wd = password.peer.getText

        // create the statement, and run the select query
        val statement = connection.createStatement()
        val res = statement.executeQuery("SELECT * FROM login where username ='" + (username.peer.getText) + "' and passsword='" + (password.peer.getText) + "'")
        val a = res.first()
        println(a)
        println(username.peer.getText, password.peer.getText)
        if (a.!=(false)) {
          Dialog.showMessage(contents.head, "Login Sucess")
          welcome
        } else {

          Dialog.showMessage(contents.head, "please enter valid usename and password")
        }
      } catch {
        case e => e.printStackTrace
      }
      connection.close()

    }

    def cancel {

      val res = Dialog.showConfirmation(contents.head, "Do you really want to quit?", optionType = Dialog.Options.YesNo, title = "close")
      if (res == Dialog.Result.Ok)
        sys.exit()
    }

    def Registration {
      val firstname = new TextField { columns = 12 }
      val lastname = new TextField { columns = 12 }
      val Username = new TextField { columns = 12 }
      val Password = new TextField { columns = 10 }
      val Month = new ComboBox(List("Select Month", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"))
      val Dte = new ComboBox(List("Select Date", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"))
      val yr = new ComboBox(List("Select Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"))
      val Phone = new TextField { columns = 12 }
      val Address1 = new TextField { columns = 12 }
      val Address2 = new TextField { columns = 12 }
      val City = new TextField { columns = 12 }
      val State = new ComboBox(List("Select State", "AL Alabama", "AK Alaska", "AZ Arizona", "AR Arkansas", "CA California", "CO Colorado", "CT Connecticut", "DE Delaware", "DC District Of Columbia", "FL Florida", "GA Georgia", "HI Hawaii", "ID Idaho", "IL Illinois", "IN Indiana", "IA Iowa", "KS Kansas", "KY Kentucky", "LA Louisiana", "ME Maine", "MD Maryland", "MA Massachusetts", "MI Michigan", "MN Minnesota", "MS Mississippi", "MO Missouri", "MT Montana", "NE Nebraska", "NV Nevada", "NH New Hampshire", "NJ New Jersey", "NM New Mexico", "NY New York", "NC North Carolina", "ND North Dakota", "OH Ohio", "OK Oklahoma", "OR Oregon", "PA Pennsylvania", "RI Rhode Island", "SC South Carolina", "SD South Dakota", "TN Tennessee", "TX Texas", "UT Utah", "VT Vermont", "VA Virginia", "WA Washington", "WV West Virginia", "WI Wisconsin", "WY Wyoming"))
      //val State       =    new TextField { columns=12 }
      val ZipCode = new TextField { columns = 12 }
      title = " Registration page"
      contents = new BoxPanel(Orientation.Vertical) {
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(15)
          contents += new Label("First Name")
          contents += Swing.HStrut(15)
          contents += firstname
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(16)
          contents += new Label("Last Name")
          contents += Swing.HStrut(16)
          contents += lastname
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(17)
          contents += new Label("UserName")
          contents += Swing.HStrut(17)
          contents += Username
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(19)
          contents += new Label("Password")
          contents += Swing.HStrut(19)
          contents += Password
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(20)
          contents += new Label("DOB")
          contents += Swing.HStrut(48)
          contents += Month
          contents += Swing.HStrut(0)
          contents += Dte
          contents += Swing.HStrut(0)
          contents += yr
        }

        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(20)
          contents += new Label("Phone")
          contents += Swing.HStrut(38)
          contents += Phone
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(18)
          contents += new Label("Address1")
          contents += Swing.HStrut(18)
          contents += Address1
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(18)
          contents += new Label("Address2")
          contents += Swing.HStrut(18)
          contents += Address2
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(19)
          contents += new Label("City")
          contents += Swing.HStrut(51)
          contents += City
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(18)
          contents += new Label("State")
          contents += Swing.HStrut(46)
          contents += State
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(18)
          contents += new Label("Zip Code")
          contents += Swing.HStrut(21)
          contents += ZipCode
        }
        contents += new BoxPanel(Orientation.Horizontal) {
          contents += Swing.HStrut(15)
          contents += new Button(Action("Sign Up") { signup })
          contents += Swing.HStrut(15)
          contents += new Button(Action("Clear") { clear })
          contents += Swing.HStrut(15)
          contents += new Button(Action("Signin") { Goback })
        }
        border = Swing.TitledBorder(Swing.LineBorder(java.awt.Color.BLUE), "Registration")
      }
      //size = new Dimension(500,100)
      centerOnScreen()

      def Goback {
        val username = new TextField { columns = 12 }
        val password = new PasswordField { columns = 12 }
        title = "Login Page"
        contents = new BoxPanel(Orientation.Vertical) {

          contents += new BoxPanel(Orientation.Horizontal) {
            contents += Swing.HStrut(5)
            contents += new Label("Username")
            contents += username
          }
          contents += new BoxPanel(Orientation.Horizontal) {
            contents += Swing.HStrut(8)
            contents += new Label("Password")
            contents += password
          }
          border = Swing.TitledBorder(Swing.LineBorder(java.awt.Color.BLUE), "Login")
          contents += new BoxPanel(Orientation.Horizontal) {
            contents += Swing.HStrut(5)
            contents += new Button(Action("Sign in") { signin })
            contents += new Button(Action("Cancle") { cancel })
            contents += new Button(Action("Register") { Registration })
          }

        }
        centerOnScreen()
      }

      def signup {
        //val pattern = new Regex("[a-z]d+")
        if (firstname.text.isEmpty()) Dialog.showMessage(contents.head, "Please enter the First name", title = "Validator")
        else if (lastname.text.isEmpty()) Dialog.showMessage(contents.head, "Please enter the Last name", title = "Validator")
        else if (Username.text.isEmpty() && Username.text.length() < 6) Dialog.showMessage(contents.head, "Please enter the User name", title = "Validator")
        else if (Password.text.isEmpty() && Password.text.length().<=(15)) Dialog.showMessage(contents.head, "Please enter the Password", title = "Validator")
        else if (Month.item.equals("Select Month")) Dialog.showMessage(contents.head, "Please enter the Month", title = "Validator")
        else if (Dte.item.equals("Select Date")) Dialog.showMessage(contents.head, "Please enter the Date", title = "Validator")
        else if (yr.item.equals("Select Year")) Dialog.showMessage(contents.head, "Please enter the Year", title = "Validator")

        else if (Phone.text.isEmpty() && Phone.text.length().<=(15)) Dialog.showMessage(contents.head, "Please enter the Phone number", title = "Validator")
        else if (Address1.text.isEmpty() && Address1.text.length().<=(15)) Dialog.showMessage(contents.head, "Please enter the Address1", title = "Validator")
        else if (Address2.text.isEmpty() && Address2.text.length().<=(15)) Dialog.showMessage(contents.head, "Please enter the Address2", title = "Validator")
        else if (City.text.isEmpty() && City.text.length().<=(15)) Dialog.showMessage(contents.head, "Please enter the City", title = "Validator")
        else if (State.item.equals("Select State")) Dialog.showMessage(contents.head, "Please enter the State", title = "Validator")
        else if (ZipCode.text.isEmpty() && ZipCode.text.length().<=(15)) Dialog.showMessage(contents.head, "Please enter the Zipcode", title = "Validator")
        else {
          val driver = "com.mysql.jdbc.Driver"
          val url = "jdbc:mysql://localhost/sample2?autoReconnect=true&useSSL=false"
          val uname = "scott"
          val pwd = "tiger"

          // there's probably a better way to do this
          var connection: Connection = null

          try {
            // make the connection
            Class.forName(driver)
            connection = DriverManager.getConnection(url, uname, pwd)
            val statement = connection.createStatement()
            val fname = firstname.peer.getText
            val lname = lastname.peer.getText
            val u_name = Username.peer.getText
            val p_wd = Password.peer.getText
            val month = Month.item
            val dt = Dte.item
            val yer = yr.item
            val phone = Phone.peer.getText
            val address1 = Address1.peer.getText
            val address2 = Address2.peer.getText
            val city = City.peer.getText
            val state = State.item
            val zipcode = ZipCode.peer.getText
            val res1 = statement.executeUpdate("insert into registration values('" + fname + "','" + lname + "','" + u_name + "','" + p_wd + "','" + month + '/' + dt + '/' + yer + "'," + phone + ",'" + address1 + "','" + address2 + "','" + city + "','" + state + "'," + zipcode + ")")

            println(res1)
            // create the statement, and run the select query

            //val res = statement.executeQuery("SELECT * FROM login where username ='" + (username.peer.getText) +"' and passsword='" +(password.peer.getText)+"'")

            //println(a)
            //println(username.peer.getText,password.peer.getText)
            if (res1.!=(false)) {
              statement.executeUpdate("insert into login values('" + u_name + "','" + p_wd + "')")
              Dialog.showMessage(contents.head, "Registration Success")
              //welcome
            } else {

              Dialog.showMessage(contents.head, "Something Wrong")
            }
          } catch {
            case e => e.printStackTrace
          }
          connection.close()
        }

      }

      //*************************This Functionality Done Don't Touch Again********************************//

      def clear {
        val res = Dialog.showConfirmation(contents.head, "Do you really want to clear?", optionType = Dialog.Options.YesNo, title = "close")
        if (res == Dialog.Result.Ok) {
          firstname.text = ""
          lastname.text = ""
          Username.text = ""
          Password.peer.setText("")
          Month.selection.index_=(0)
          Dte.selection.index_=(0)
          yr.selection.index_=(0)
          Phone.text = ""
          Address1.text = ""
          Address2.text = ""
          City.text = ""
          State.selection.index_=(0)
          ZipCode.text = ""
        }
      }

      //*************************This Functionality Done Don't Touch Again********************************//
    }

    val username = new TextField { columns = 12 }
    val password = new PasswordField { columns = 12 }
    title = "Login Page"
    contents = new BoxPanel(Orientation.Vertical) {

      contents += new BoxPanel(Orientation.Horizontal) {
        contents += Swing.HStrut(5)
        contents += new Label("Username")
        contents += username
      }
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += Swing.HStrut(8)
        contents += new Label("Password")
        contents += password
      }
      border = Swing.TitledBorder(Swing.LineBorder(java.awt.Color.BLUE), "Login")
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += Swing.HStrut(5)
        contents += new Button(Action("Sign in") { signin })
        contents += new Button(Action("Cancle") { cancel })
        contents += new Button(Action("Register") { Registration })
      }

    }
    centerOnScreen()
  }
  frame.visible = true
}