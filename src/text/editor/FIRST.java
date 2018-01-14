/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.editor;



import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.*;
import java.text.*;
import java.util.*;
import javax.swing.undo.*;
import javax.swing.event.*;
import java.net.*;
import javax.swing.text.JTextComponent;
/**
 *
 * @author Amol
 */
public class FIRST extends javax.swing.JFrame {
    
    boolean fileOpened = false;
    String file = null,
           fileN;
    
     FONT f1=new FONT();
     FIND f2=new FIND();
     String findString,sbufer;
     int ind;
     public JPopupMenu pop = new JPopupMenu();
     
	UndoManager undoMgr = new UndoManager();
	UndoAction undoAction = new UndoAction();
        RedoAction redoAction = new RedoAction();
       public static JLabel createLabel(String text) {

        return createLabel(text, UIManager.getColor("Label.foreground"));

    }

    public static JLabel createLabel(String text, Color color) {

        JLabel label = new JLabel(text);
        label.setForeground(color);
        

        return label;

    }
    public FIRST() {
        super("Text Editor");
        initComponents();
        customInit();
       
    }
    public void customInit() {
        textPanel.getDocument().addUndoableEditListener(undoMgr);
        MouseListener popupListener = new PopupListener();
	textPanel.addMouseListener(popupListener);
        JMenuItem jMenuItema=new JMenuItem("Cut");
        JMenuItem jMenuItemb=new JMenuItem("Copy");
        JMenuItem jMenuItemc=new JMenuItem("Paste");
        JMenuItem jMenuItemd=new JMenuItem("SelectAll");
	pop.add(undoAction);
	pop.add(redoAction);
        pop.addSeparator();
        pop.add(jMenuItema);
	pop.add(jMenuItemb);
	pop.add(jMenuItemc);
        pop.add(jMenuItemd);
        jMenuItema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenuItemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuItemc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenuItemd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        }); 	
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPanel = new javax.swing.JTextArea();
        statusPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuEditNew = new javax.swing.JMenuItem();
        menuEditOpen = new javax.swing.JMenuItem();
        menuEditSave = new javax.swing.JMenuItem();
        menuEditSaveAs = new javax.swing.JMenuItem();
        menuEditPrint = new javax.swing.JMenuItem();
        menuEditExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton2.setFont(new java.awt.Font("FontAwesome", 0, 16));
        jButton2.setText("\uf0f6");
        jButton2.setToolTipText("New");
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton1.setFont(new java.awt.Font("FontAwesome", 0, 16));
        jButton1.setText("\uf115");
        jButton1.setToolTipText("Open");
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton4.setFont(new java.awt.Font("FontAwesome", 0, 16));
        jButton4.setText("\uf0c7");
        jButton4.setToolTipText("Save");
        jButton4.setBorderPainted(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jSeparator1.setSeparatorSize(new java.awt.Dimension(5, 0));
        jToolBar1.add(jSeparator1);

        jLabel1.setText("|");
        jToolBar1.add(jLabel1);
        jToolBar1.add(jSeparator2);

        jButton3.setFont(new java.awt.Font("FontAwesome", 0, 16));
        jButton3.setText("\uf0c4");
        jButton3.setToolTipText("Cut");
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton5.setFont(new java.awt.Font("FontAwesome", 0, 16));
        jButton5.setText("\uf0c5");
        jButton5.setToolTipText("Copy");
        jButton5.setBorderPainted(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setFont(new java.awt.Font("FontAwesome", 0, 16));
        jButton6.setText("\uf0ea");
        jButton6.setToolTipText("Paste");
        jButton6.setBorderPainted(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        textPanel.setColumns(20);
        textPanel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textPanel.setRows(5);
        textPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textPanelMouseClicked(evt);
            }
        });
        textPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPanelKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(textPanel);

        statusPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        statusPanel.setToolTipText("");
        statusPanel.setMaximumSize(new java.awt.Dimension(1000, 20));
        statusPanel.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                statusPanelInputMethodTextChanged(evt);
            }
        });
        statusPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                statusPanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        menuEditNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuEditNew.setText("New");
        menuEditNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditNewActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditNew);

        menuEditOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuEditOpen.setText("Open");
        menuEditOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditOpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditOpen);

        menuEditSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuEditSave.setText("Save");
        menuEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditSaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditSave);

        menuEditSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuEditSaveAs.setText("Save As");
        menuEditSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditSaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditSaveAs);

        menuEditPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menuEditPrint.setText("Print");
        menuEditPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditPrintActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditPrint);

        menuEditExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuEditExit.setText("Exit");
        menuEditExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Undo");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Redo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Cut");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Copy");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Paste");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem12.setText("Delete");
        jMenu2.add(jMenuItem12);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setText("Find & Replace");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setText("Go To");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setText("Select All");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem17);

        jMenuItem18.setText("Time/Date");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Format");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jCheckBoxMenuItem1.setText("Word Wrap");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jCheckBoxMenuItem1);

        jMenuItem19.setText("Font");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem19);

        jMenuItem22.setText("Font Colour");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem22);

        jMenuItem21.setText("Themes");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem21);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("View");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Status Bar");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Help");

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem20.setText("About");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem20);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    class PopupListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {

            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                pop.show(e.getComponent(),
                           e.getX(), e.getY());
            }
        }
    }
    
    /* saveFile() is invoked to write the contents of textPanel to a new file using
     * the FileWriter class. If file is not yet saved,
     */
    
    public void saveFile() {
        String line = textPanel.getText();
        if(fileOpened==true) {
            try {
                FileWriter output = new FileWriter(file);
                BufferedWriter bufout = new BufferedWriter(output);
                bufout.write(line, 0, line.length());
                // Change needed.
                JOptionPane.showMessageDialog(null, "Save Successful");
                bufout.close();
                output.close();
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }
        else {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(new JPanel());
            if(result == JFileChooser.APPROVE_OPTION) {
                fileN = String.valueOf(fc.getSelectedFile());
                try {
                    FileWriter output = new FileWriter(fileN);
                    BufferedWriter bufout = new BufferedWriter(output);
                    bufout.write(line, 0, line.length());
                    JOptionPane.showMessageDialog(null, "Save Successful");
                    bufout.close();
                    output.close();
                    fileOpened = true;
                } catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
    
    class NewFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
            {
                    fileOpened = false;
                    if(textPanel.getText().equals("")) {
                            System.out.print("textPanel is empty.");
                    }
                    else {
                        int confirm = JOptionPane.showConfirmDialog(null,
                            "Would you like to save?",
                            "New File",
                            JOptionPane.YES_NO_CANCEL_OPTION);

                        if(confirm == JOptionPane.YES_OPTION) {
                            saveFile();
                            textPanel.setText(null);
                            statusPanel.removeAll();
                            statusPanel.validate();
                        }
                        else if(confirm == JOptionPane.CANCEL_OPTION) {}
                        else if(confirm == JOptionPane.NO_OPTION) {
                                textPanel.setText(null);
                                statusPanel.removeAll();
                                statusPanel.validate();
                        }
                    }
            }
    }
    
    class PrintFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(textPanel.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Text Area is empty.");
            else
                print(textPanel.getText());
        }
    }
    
    class SaveFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            saveFile();
	}
    }
    
    /*
     * print(String) takes in the text from textPanel and uses it to create a 
     * LineNumberReader object which is used to read the contents of the String
     * line by line.
     */
    
    private void print(String s) {
        //StringReader sr = null;
        LineNumberReader lnr = new LineNumberReader(new StringReader(s));
        Font typeface = new Font("Monospaced", Font.PLAIN, 12);
        Properties p = new Properties();
        PrintJob pjob = getToolkit().getPrintJob(this, "Print report", p);

        if (pjob != null) {
            Graphics pg = pjob.getGraphics();
            if (pg != null) {
                FontMetrics fm = pg.getFontMetrics(typeface);
                int margin = 20;
                int pageHeight = pjob.getPageDimension().height - margin;
                int fontHeight = fm.getHeight();
                int fontDescent = fm.getDescent();
                int curHeight = margin;
                String nextLine;
                pg.setFont (textPanel.getFont());
                try {
                    do {
                        nextLine = lnr.readLine();
                        if (nextLine != null) {
                            if ((curHeight + fontHeight) > pageHeight) {
                                // New Page
                                pg.dispose();
                                pg = pjob.getGraphics();
                                curHeight = margin;
                            }
                            curHeight += fontHeight;
                            if (pg != null) {
                                    pg.setFont (typeface);
                                    pg.drawString (nextLine, margin, curHeight - fontDescent);
                            }
                        }
                    } while (nextLine != null);
                }
                catch (EOFException eof) {
                }
                catch (Throwable t) {
                    t.printStackTrace();
                }
            }
            pg.dispose();
        }
        if (pjob != null)
            pjob.end();
    }

    // 
    private void menuEditNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditNewActionPerformed
        // TODO add your handling code here:
        menuEditNew.addActionListener(new NewFileListener());
    }//GEN-LAST:event_menuEditNewActionPerformed

    private void menuEditOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEditOpenActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        undoMgr.redo();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        textPanel.paste();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void menuEditExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuEditExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        
	JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        JLabel a1=new JLabel("TEXT EDITOR");
        a1.setFont(new Font("Times New Roman", Font.BOLD, 60));
        pnl.add(a1);
        JLabel a2=new JLabel("Authors-");
        a2.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        pnl.add(a2);
        JLabel a3=new JLabel("1. Sangeeth Sudheer");
        a3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        pnl.add(a3);
         JLabel a4=new JLabel("2. AadithyaVarma");
        a4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        pnl.add(a4);
         JLabel a5=new JLabel("3. Amol Suraj Mishra");
        a5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        pnl.add(a5);
        JOptionPane.showMessageDialog(f1, pnl,"About Us",JOptionPane.INFORMATION_MESSAGE);
	
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
       	f1.setVisible(true);
		f1.jButton1.addActionListener(new ActionListener ()
		{
		public void actionPerformed(ActionEvent ae)
		{
			Font selectedFont = f1.returnfont();
			textPanel.setFont(selectedFont);
			f1.setVisible(false);
		}
	});
			
	f1.jButton2.addActionListener(new ActionListener ()
	{
		public void actionPerformed(ActionEvent ae)
		{
		f1.setVisible(false);
		}
	});
                
			
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void textPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPanelMouseClicked
    }//GEN-LAST:event_textPanelMouseClicked

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        THEMES t1=new THEMES();
        t1.setVisible(true);
        t1.jButton1.addActionListener(new ActionListener ()
	{
            public void actionPerformed(ActionEvent ae)
		{
                	int i=t1.value();
                        if(i==0){
                            textPanel.setBackground(new java.awt.Color(255, 255, 255));
                            textPanel.setForeground(new java.awt.Color(0, 0, 0)); 
                        }
                        else if(i==1){
                            textPanel.setBackground(new java.awt.Color(0,0,0));
                            textPanel.setForeground(new java.awt.Color(255,255,255)); 
                        }
                        else if(i==2){
                            textPanel.setBackground(new java.awt.Color(2, 218, 211));
                            textPanel.setForeground(new java.awt.Color(255,255,255)); 
                        }
                        else if(i==3){
                            textPanel.setBackground(new java.awt.Color(207, 43, 196));
                            textPanel.setForeground(new java.awt.Color(255,255,255)); 
                        }
			                       
			t1.setVisible(false);
		}
	});
			
	t1.jButton2.addActionListener(new ActionListener ()
	{
            public void actionPerformed(ActionEvent ae)
		{
                    	t1.setVisible(false);
		}
	});
        
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
        COLOR c1=new COLOR();
        c1.setVisible(true);
       c1.jButton1.addActionListener(new ActionListener ()
	{
            public void actionPerformed(ActionEvent ae)
		{
                    int a=c1.mycolor();
                    if(a==1){
                        textPanel.setForeground(Color.black); 
                    }
                    else if(a==2){
                        textPanel.setForeground(Color.white); 
                    }
                    else if(a==3){
                        textPanel.setForeground(Color.red); 
                    }
                    else if(a==4){
                        textPanel.setForeground(Color.green); 
                    }
                    else if(a==5){
                        textPanel.setForeground(Color.blue); 
                    }
                    else if(a==6){
                        textPanel.setForeground(Color.yellow); 
                    }
                    else if(a==7){
                        textPanel.setForeground(Color.orange); 
                    }
                    else if(a==8){
                        textPanel.setForeground(Color.pink); 
                    }
                    else if(a==9){
                        textPanel.setForeground(Color.magenta); 
                    }
                    else if(a==10){
                        textPanel.setForeground(Color.cyan); 
                    }
                    else if(a==11){
                        textPanel.setForeground(Color.gray); 
                    }
                    else if(a==12){
                        textPanel.setForeground(Color.lightGray); 
                    }
                    else if(a==13){
                        textPanel.setForeground(Color.darkGray); 
                    }
                    c1.setVisible(false);
                }
        }
       );
       
       c1.jButton2.addActionListener(new ActionListener ()
	{
            public void actionPerformed(ActionEvent ae)
		{
                    	c1.setVisible(false);
		}
	});
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        undoMgr.undo();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        textPanel.cut();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        textPanel.copy();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        textPanel.paste();
    }//GEN-LAST:event_jMenuItem11ActionPerformed
                              

    
    
    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        textPanel.selectAll();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        textPanel.cut();
    }//GEN-LAST:event_jButton3ActionPerformed
int ind1=0;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        textPanel.copy();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        f2.setVisible(true);
        
        f2.jButton1.addActionListener(new ActionListener ()
          {
           
            public void actionPerformed(ActionEvent e)
			{
				try
				{
                                    sbufer = textPanel.getText();
                                    sbufer=sbufer.toLowerCase();
					findString = f2.jTextField1.getText();
                                        findString=findString.toLowerCase();
                                        if(sbufer.indexOf(findString)==-1)
                                          {
                                            textPanel.setCaretPosition(0);
                                          }
                                        else
                                          {
                                            ind = sbufer.indexOf(findString,ind1);
                                          }
					textPanel.setCaretPosition(ind);
					textPanel.setSelectionStart(ind);
					textPanel.setSelectionEnd(ind+findString.length());
                                        ind1=ind+findString.length();
				}
				catch(IllegalArgumentException | NullPointerException npe)
				{
					//JOptionPane.showMessageDialog(null, "String not found");
				}
			}
            });
        f2.jButton2.addActionListener((ActionEvent e) ->
          {
            textPanel.replaceRange(f2.jTextField2.getText(), ind, ind+findString.length());
          });
        f2.jButton3.addActionListener((ActionEvent e) ->
          {
            ind1=0;
            textPanel.setCaretPosition(ind1);
            f2.setVisible(false);
          });
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void menuEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditSaveActionPerformed
        // TODO add your handling code here:
        menuEditSave.addActionListener(new SaveFileListener());
    }//GEN-LAST:event_menuEditSaveActionPerformed

    private void menuEditSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditSaveAsActionPerformed
        // TODO add your handling code here:
        menuEditSaveAs.addActionListener((ActionEvent e) -> {
            fileOpened = false;
            saveFile();
        });
    }//GEN-LAST:event_menuEditSaveAsActionPerformed

    private void menuEditPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditPrintActionPerformed
        // TODO add your handling code here:
        menuEditPrint.addActionListener(new PrintFileListener());
    }//GEN-LAST:event_menuEditPrintActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
         try
				{	
					Element root = textPanel.getDocument().getDefaultRootElement();
                                        GOTO g=new GOTO();
                                        g.setVisible(true);
                                        g.jButton1.addActionListener(new ActionListener ()
                                         {
           
                                         public void actionPerformed(ActionEvent e)
                                            {
                                                int p=Integer.parseInt(g.jTextField1.getText());
                                                Element root = textPanel.getDocument().getDefaultRootElement();
                                                Element paragraph=root.getElement(p);
                                                textPanel.setCaretPosition(paragraph.getStartOffset()-1);
                                                g.setVisible(false);
                                            }
					//Element paragraph=root.getElement(Integer.parseInt(JOptionPane.showInputDialog(null, "Go to line")));
					//textPanel.setCaretPosition(paragraph.getStartOffset()-1);
				});
                                                }catch(NullPointerException npe)
				{
					JOptionPane.showMessageDialog(null, "Invalid line number");
				}catch(NumberFormatException nfe)
				{
					
				}
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxMenuItem1.isSelected())
				textPanel.setLineWrap(true);
				else
				textPanel.setLineWrap(false);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        Date currentDate;
	SimpleDateFormat formatter;
	String dd;
	formatter = new SimpleDateFormat("KK:mm aa MMMMMMMMM dd yyyy", Locale.getDefault());
	currentDate = new java.util.Date();
	dd = formatter.format(currentDate);
	textPanel.insert(dd,textPanel.getCaretPosition());
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxMenuItem2.isSelected()){
            statusPanel.setVisible(true);        
        }
        else{
             statusPanel.setVisible(false);
        }
       
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void statusPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_statusPanelKeyPressed

    }//GEN-LAST:event_statusPanelKeyPressed

    private void textPanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPanelKeyTyped
       
    }//GEN-LAST:event_textPanelKeyTyped

    private void statusPanelInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_statusPanelInputMethodTextChanged
        
    }//GEN-LAST:event_statusPanelInputMethodTextChanged

    
    
    public class MyUndoableEditListener
          implements UndoableEditListener
{
    public void undoableEditHappened(UndoableEditEvent e) {
        //Remember the edit and update the menus
        undoMgr.addEdit(e.getEdit());
        undoAction.update();
        redoAction.update();
    }
}  

   class UndoAction extends AbstractAction {
	public UndoAction() {
	    super("Undo");
	    setEnabled(true);
	}

	public void actionPerformed(ActionEvent e) {
	    try {
		undoMgr.undo();
	    } catch (CannotUndoException ex) {
		System.out.println("Unable to undo: " + ex);
		ex.printStackTrace();
	    }
	    update();
	    redoAction.update();
	}

	protected void update() {
	    if(undoMgr.canUndo()) {
		setEnabled(true);
		putValue("Undo", undoMgr.getUndoPresentationName());
	    }
	    else {
		setEnabled(false);
		putValue(Action.NAME, "Undo");
	    }
	}
    }
   
   
   
   
   class RedoAction extends AbstractAction {
	public RedoAction() {
	    super("Redo");
	    setEnabled(true);
	}

	public void actionPerformed(ActionEvent e) {
	    try {
		undoMgr.redo();
	    } catch (CannotRedoException ex) {
		System.out.println("Unable to redo: " + ex);
		ex.printStackTrace();
	    }
	    update();
	    undoAction.update();
	}

	protected void update() {
	    if(undoMgr.canRedo()) {
		setEnabled(true);
		putValue("Redo", undoMgr.getRedoPresentationName());
	    }
	    else {
		setEnabled(false);
		putValue(Action.NAME, "Redo");
	    }
	}
    }
    
   
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FIRST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FIRST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FIRST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FIRST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FIRST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuEditExit;
    private javax.swing.JMenuItem menuEditNew;
    private javax.swing.JMenuItem menuEditOpen;
    private javax.swing.JMenuItem menuEditPrint;
    private javax.swing.JMenuItem menuEditSave;
    private javax.swing.JMenuItem menuEditSaveAs;
    private javax.swing.JPanel statusPanel;
    public javax.swing.JTextArea textPanel;
    // End of variables declaration//GEN-END:variables
    
}
