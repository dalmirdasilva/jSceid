package jsceid;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageViewer extends JFrame implements ActionListener {

    public ImageViewer() {
        setTitle("ImageViewer");
        setSize(300, 400);

        JMenuBar mbar = new JMenuBar();
        JMenu m = new JMenu("File");
        openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        m.add(openItem);
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        m.add(exitItem);
        mbar.add(m);
        setJMenuBar(mbar);

        label = new JLabel();
        Container contentPane = getContentPane();
        contentPane.add(label, "Center");
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == openItem) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("/home/dalmir/Desktop"));

            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif")
                            || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });

            int r = chooser.showOpenDialog(this);
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getAbsolutePath();
                label.setIcon(new ImageIcon(name));
            }
        } else if (source == exitItem) {
            System.exit(0);
        }
    }

    
    public void abc(byte[] i) {
        label.setIcon(new ImageIcon(i));
    }
    
    public static void main(String[] args) {
        JFrame frame = new ImageViewer();
        frame.show();
    }
    
    private JLabel label;
    private JMenuItem openItem;
    private JMenuItem exitItem;
}
