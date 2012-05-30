/**
 * ObjectCache
 * 23.02.2012
 * @author Philipp Haussleiter
 *
 */
package com.innoq.liqid.utils;

import com.innoq.liqid.model.Node;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectCache {

    private final static Logger LOG = Logger.getLogger(ObjectCache.class.getName());

    /**
     * Loads a Node from Cache File.
     * @param filename
     * @return Node that was loaded.
     */
    public static Node loadNodeCache(String filename) {
        Node node = null;
        File cacheFile = new File(filename);
        if (cacheFile.exists()) {
            FileInputStream f_in = null;
            try {
                f_in = new FileInputStream(filename);
                ObjectInputStream obj_in = new ObjectInputStream(f_in);
                Object obj = obj_in.readObject();
                if (obj instanceof Node) {
                    node = (Node) obj;
                }
            } catch (ClassNotFoundException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } finally {
                try {
                    f_in.close();
                } catch (IOException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                }
            }
        }
        return node;
    }

    /**
     * Loads a Set of Nodes from Cache File.
     * @param filename
     * @return Set of Nodes that were loaded.
     */
    public static Set<Node> loadNodesCache(String filename) {
        Set<Node> nodes = null;
        File cacheFile = new File(filename);
        if (cacheFile.exists()) {
            FileInputStream f_in = null;
            try {
                f_in = new FileInputStream(filename);
                ObjectInputStream obj_in = new ObjectInputStream(f_in);
                Object obj = obj_in.readObject();
                if (obj instanceof Set) {
                    nodes = (Set<Node>) obj;
                }
            } catch (ClassNotFoundException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } finally {
                try {
                    f_in.close();
                } catch (IOException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                }
            }
        }
        return nodes;
    }

    /**
     * Saves a Set of Nodes to a Cache File.
     * @param filename
     */
    public static void saveNodesCache(Set<Node> nodes, String filename) {
        FileOutputStream f_out = null;
        try {
            f_out = new FileOutputStream(filename);
            ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
            obj_out.writeObject(nodes);
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } finally {
            try {
                f_out.close();
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Saves a Node to a Cache File.
     * @param filename
     */
    public static void saveNodeCache(Node node, String filename) {
        FileOutputStream f_out = null;
        try {
            f_out = new FileOutputStream(filename);
            ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
            obj_out.writeObject(node);
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } finally {
            try {
                f_out.close();
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
    }
}