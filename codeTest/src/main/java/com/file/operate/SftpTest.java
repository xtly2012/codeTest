package com.file.operate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.provider.sftp.SftpClientFactory;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

/**
 * Created by chen on 2014/7/10.
 */
public class SftpTest {

    public static void main(String[] argus) {
        try {
            char[] userName = "test184".toCharArray();
            char[] userPwd = "aA111184".toCharArray();
            FileSystemOptions options = new FileSystemOptions();
            SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(options, "no");
            Session session = SftpClientFactory.createConnection("192.168.111.184", 22, userName, userPwd, options);

            System.out.println("session state is " +session.isConnected());
            ChannelSftp channel;
            channel = (ChannelSftp)session.openChannel("sftp");
            channel.connect();
            String fileName = null;
            Vector<ChannelSftp.LsEntry> vectorList = channel.ls("/apps");
            for (int i = 0; i < vectorList.size(); i++) {
                System.out.println(vectorList.get(i).toString());
                if (vectorList.get(i).getFilename().endsWith(".txt")) {
                    fileName = vectorList.get(i).getFilename();
                }
            }

            InputStream input = channel.get("/apps/" +fileName);
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line;
            while ((line = bufReader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("input stream state is " +input);


            System.out.println("channel state is " +channel.isConnected());

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
        	FileSystemManager fileSysManager = VFS.getManager();
        	FileObject fileObject = fileSysManager.resolveFile("");
        } catch (Exception e) {
        	e.printStackTrace();
        }
        

    }
}
