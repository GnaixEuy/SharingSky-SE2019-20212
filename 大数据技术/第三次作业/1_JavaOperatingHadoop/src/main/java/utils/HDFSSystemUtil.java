package utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.yarn.api.records.URL;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/23
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

public class HDFSSystemUtil {

	private static FileSystem fileSystem = null;

	private static URI url = null;

	static {
		try {
			HDFSSystemUtil.url = new URI("hdfs://10.211.55.41:9000/");
			HDFSSystemUtil.fileSystem = FileSystem.get(HDFSSystemUtil.url, new Configuration());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static FileSystem getFileSystem() {
		return HDFSSystemUtil.fileSystem;
	}

}
