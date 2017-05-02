package org.project.Ui

import scala.swing._
import java.time.Year
import scala.util.matching.Regex
import java.sql.DriverManager
import java.sql.Connection
import java.util.Calendar
import java.text.SimpleDateFormat
import org.apache.hadoop._
import org.apache.spark.sql.hive.orc._
import org.apache.spark.sql._
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types._
import org.apache.spark.storage.StorageLevel._
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.DataFrame

object task extends App
{
  val frame1 = new MainFrame
  {
    val UploadFile = new TextField
    def openFile
    {
      val chooser = new FileChooser
      if(chooser.showOpenDialog(null)==FileChooser.Result.Approve)
      {
        val source = scala.io.Source.fromFile(chooser.selectedFile)
        var a = chooser.selectedFile
        UploadFile.text= a.getPath
        source.close()
      }
    }
    def saveFile{
    val chooser = new FileChooser
    if(chooser.showSaveDialog(null)==FileChooser.Result.Approve){
      val pw = new java.io.PrintWriter(chooser.selectedFile)
      
      pw.close()
    }
    
  }
      title = "Tast Assignment"
      contents = new BoxPanel(Orientation.Vertical)
      {
        contents += new BoxPanel(Orientation.Horizontal)
        {
          contents += Swing.HStrut(15)
          contents += new Label("File Upload")
          contents += UploadFile
        }
        contents += new BoxPanel(Orientation.Horizontal)
        {
          contents += Swing.HStrut(15)
          contents += new Button(Action("Upload File"){
          openFile
           })
        }
        contents += new BoxPanel(Orientation.Horizontal)
        {
          contents += Swing.HStrut(15)
          contents += new Button(Action("Save"){
          saveFile
           })
        }
        contents += new BoxPanel(Orientation.Horizontal)
        {
          contents += Swing.HStrut(15)
          contents += new Button(Action("Table Selection"){
          loadFile
      def loadFile
      {
        var dm1 = List[String]()
        //val genre = new ComboBox(dm)
        val driver = "com.mysql.jdbc.Driver"
        val url = "jdbc:mysql://localhost/sample4?autoReconnect=true&useSSL=false"
        val uname = "scott"
        val pwd = "tiger" // there's probably a better way to do this
        var connection: Connection = null
        try
        {
          Class.forName(driver)
          connection = DriverManager.getConnection(url, uname, pwd)
          println(connection)
          val statement = connection.createStatement()
          val res = statement.executeQuery("show tables")
          //val genre = new ComboBox(dm)
          while (res.next())
          {
            val b = res.getString("Tables_in_sample4")
            println(b)
            if (b.length() != 0) { dm1 = b :: dm1 }
          }
          val selection = new ComboBox(dm1)
            contents += new BoxPanel(Orientation.Vertical)
            {
              contents += new BoxPanel(Orientation.Horizontal)
              {
                contents += Swing.HStrut(15)
                contents += new Label("Make A Selection")
                contents += selection
              }
            }
        }    
        catch
        {
          case e => e.printStackTrace
        }
        connection.close()
      }
           })
        }
      }
  }
  frame1.visible=true 
}