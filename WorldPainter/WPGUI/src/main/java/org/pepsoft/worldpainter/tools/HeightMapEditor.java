/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pepsoft.worldpainter.tools;

import java.util.Random;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import org.pepsoft.minecraft.Constants;
import org.pepsoft.util.swing.TileProvider;
import org.pepsoft.worldpainter.HeightMap;
import org.pepsoft.worldpainter.Terrain;
import org.pepsoft.worldpainter.TileFactoryFactory;
import org.pepsoft.worldpainter.heightMaps.gui.HeightMapTileProvider;
import org.pepsoft.worldpainter.heightMaps.gui.HeightMapTreeModel;
import org.pepsoft.worldpainter.heightMaps.gui.HeightMapTreeCellRenderer;

/**
 *
 * @author pepijn
 */
public class HeightMapEditor extends javax.swing.JFrame {
    /**
     * Creates new form HeightMapEditor
     */
    public HeightMapEditor() {
        initComponents();
        createHeightMap();
    }
    
    private void createHeightMap() {
        HeightMap heightMap = TileFactoryFactory.createFancyTileFactory(new Random().nextLong(), Terrain.GRASS, Constants.DEFAULT_MAX_HEIGHT_2, 62, 58, false, 20f, 1.0).getHeightMap();
//        NoiseHeightMap noise = new NoiseHeightMap("Noise", 255f, 5.0, 3);
//        NoiseHeightMap angleMap = new NoiseHeightMap("Angle", (float) (Math.PI * 2), 2.5f, 1);
//        NoiseHeightMap distanceMap = new NoiseHeightMap("Distance", 25f, 2.5f, 1);
//        return new DisplacementHeightMap(noise, angleMap, distanceMap);
        TileProvider tileProvider = new HeightMapTileProvider(heightMap);
        tiledImageViewer1.setTileProvider(tileProvider);
        TreeModel treeModel = new HeightMapTreeModel(heightMap);
        jTree1.setModel(treeModel);
        TreeCellRenderer cellRenderer = new HeightMapTreeCellRenderer(heightMap);
        jTree1.setCellRenderer(cellRenderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        tiledImageViewer1 = new org.pepsoft.util.swing.TiledImageViewer();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        heightMapPropertiesPanel1 = new org.pepsoft.worldpainter.heightMaps.gui.HeightMapPropertiesPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Height Map Editor");

        jToolBar1.setRollover(true);

        jButton1.setText("New Seed");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        jSplitPane1.setRightComponent(tiledImageViewer1);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jSplitPane2.setLeftComponent(jScrollPane1);
        jSplitPane2.setRightComponent(heightMapPropertiesPanel1);

        jSplitPane1.setLeftComponent(jSplitPane2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        if (jTree1.getSelectionCount() == 1) {
            HeightMap heightMap = (HeightMap) jTree1.getSelectionPath().getLastPathComponent();
            heightMapPropertiesPanel1.setHeightMap(heightMap);
        }
    }//GEN-LAST:event_jTree1ValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createHeightMap();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HeightMapEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.pepsoft.worldpainter.heightMaps.gui.HeightMapPropertiesPanel heightMapPropertiesPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree1;
    private org.pepsoft.util.swing.TiledImageViewer tiledImageViewer1;
    // End of variables declaration//GEN-END:variables
}
