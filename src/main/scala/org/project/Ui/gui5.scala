package org.project.Ui

import scala.swing._

class UI5 extends MainFrame {
  def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }

  title = "GUI Program #5"
  
  val nameField = new TextField { columns = 32 }
  val likeScala = new CheckBox("I like Scala")
  //likeScala.selected = true
  val status1 = new RadioButton("학부생")
  val status2 = new RadioButton("대학원생")
  val status3 = new RadioButton("교수")
  status3.selected = true
  val statusGroup = new ButtonGroup(status1, status2, status3)
  val gender = new ComboBox(List("don't know", "female", "male"))
  val commentField = new TextArea { rows = 8; lineWrap = true; wordWrap = true }
  val pressMe = new ToggleButton("Press me!")
  pressMe.selected = true

  restrictHeight(nameField)
  restrictHeight(gender)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("My name")
      contents += Swing.HStrut(5)
      contents += nameField
    }
    contents += Swing.VStrut(5)
    contents += likeScala
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += status1
      contents += Swing.HStrut(10)
      contents += status2
      contents += Swing.HStrut(10)
      contents += status3
    }
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Gender")
      contents += Swing.HStrut(20)
      contents += gender
    }
    contents += Swing.VStrut(5)
    contents += new Label("Comments")
    contents += Swing.VStrut(3)
    contents += new ScrollPane(commentField)
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += pressMe
      contents += Swing.HGlue
      contents += Button("Close") { reportAndClose() }
    }
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }

  def reportAndClose() {
    println("Your name: " + nameField.text)
    println("You like Scala: " + likeScala.selected)
    println("Undergraduate: " + status1.selected)
    println("Graduate: " + status2.selected)
    println("Professor: " + status3.selected)
    println("Gender: " + gender.selection.item + 
	    " (Index: " + gender.selection.index + ")")
    println("Comments: " + commentField.text)
    println("'Press me' is pressed: " + pressMe.selected)
    sys.exit(0)
  }
}

object GuiProgramFive {
  def main(args: Array[String]) {
    val ui = new UI5
    ui.visible = true
  }
}