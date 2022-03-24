### HDFS-JavaAPI

---

编写Java代码实现以下操作：

1.  在windows中编写java代码连接Linux上的HDFS，
2.  用Java代码在Linux上的HDFS根目录下创建文件夹“input”，
3.  将本地文件word.txt上传到HDFS的input文件夹下。
4.  删除HDFS上除input文件夹以外的其他文件和目录

---

##### HDFSSystemUtil:

```java
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
```

##### HDFSTest:

```java
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import utils.HDFSSystemUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/23
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public class HDFSTest {

	@Test
	public void  read() throws IOException {
		final FileSystem fileSystem = HDFSSystemUtil.getFileSystem();
		final FSDataInputStream openStream = fileSystem.open(new Path("hdfs://10.211.55.41:9000/tmp/Hello"));
		IOUtils.copyBytes(openStream,System.out,1024,false);
	}

	@Test
	public void mkdir() throws IOException {
		final FileSystem fileSystem = HDFSSystemUtil.getFileSystem();
		final boolean mkdirs = fileSystem.mkdirs(new Path("hdfs://10.211.55.41:9000/input/"));
		Assert.assertTrue(mkdirs);
	}

	@Test
	public void  upload() throws IOException {
		final FileSystem fileSystem = HDFSSystemUtil.getFileSystem();
		final FileInputStream fileInputStream = new FileInputStream("/Users/gnaixeuy/Desktop/Hello");
		final FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/input/word.txt"));
		IOUtils.copyBytes(fileInputStream,fsDataOutputStream,1024,false);
	}

	@Test
	public void  delete() throws IOException {
		final FileSystem fileSystem = HDFSSystemUtil.getFileSystem();
		final URI uri = fileSystem.getUri();
		final FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/"));
		for (FileStatus fileStatus : fileStatuses) {
			if (fileStatus.isDirectory()){
				final String s = fileStatus.getPath().toString().replaceAll(uri.toString(), "");
				if (!s.equals("/input")){
					final boolean delete = fileSystem.delete(new Path(s), true);
					Assert.assertTrue(delete);
				}
			}
		}
	}
}
```

<img src="Java API操作HDFS.assets/截屏2022-03-24 15.58.22.png" alt="截屏2022-03-24 15.58.22" style="zoom:50%;" />