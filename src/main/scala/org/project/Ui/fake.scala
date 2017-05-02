package org.project.Ui

import swing._

object GuiDemo extends SimpleSwingApplication {
  lazy val top = new MainFrame {
    val comboBox = new ComboBox(List("a", "b", "c"))
    val button   = Button("Go!") {
      val selection = comboBox.item
      Console.out.println(selection)
      //sys.exit(0)
    }

    contents = new FlowPanel(comboBox, button)
  }
}
