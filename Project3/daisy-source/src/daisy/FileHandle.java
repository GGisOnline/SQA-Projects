/* 
 * This file is part of the Daisy distribution.  This software is
 * distributed 'as is' without any guarantees whatsoever. It may be
 * used freely for research but may not be used in any commercial
 * products.  The contents of this distribution should not be posted
 * on the web or distributed without the consent of the authors.
 *
 * Authors: Cormac Flanagan, Stephen N. Freund, Shaz Qadeer 
 * Contact: Shaz Qadeer (qadeer@microsoft.com)
 */

package daisy;

public class FileHandle {

    /* ----------
     * Added part
     * ---------- */

    //Setting variables for our modification 
    public volatile long inodenum;
    private boolean initialized = false;

    //Synchronize modification of inodenum
    public synchronized void setInodenum(long inodenum) {
        this.inodenum = inodenum;
        this.initialized = true;
    }

    //Synchronize access to inodenum
    public synchronized long getInodenum() {
        return inodenum;
    }

    //Check if Inodenum has been initialized
    public boolean isInitialized() {
        return this.initialized;
    }

    /* --------------
     * End added part
     * -------------- */


     
    public static boolean equal(FileHandle fd1, FileHandle fd2) {
        return fd1.getInodenum() == fd2.getInodenum();
    }

    public String toString() {
        return "[inodenum=" + this.inodenum + "]";
    }
}
