import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLCAT {
    static{
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws IOException {
        InputStream in = null;
        try{
            in = new URL(args[0]).openStream();
            IOUtils.copyBytes(in, System.out,2048, false);
        }finally {
            IOUtils.closeStream(in);
        }
        //hadoop jar URLCAT.jar URLCAT hdfs://hadooptest/test/2019/09/10/00/k1.1568044802426
    }
}
