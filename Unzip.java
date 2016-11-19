import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
 
class Unzip
{
	public static void extractZipFile()
	{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File dir = null;
		ZipInputStream zis = null;
		ZipEntry entry;
		
		try
		{
			dir = new File("Z:\\Check");
			dir.mkdir();

			fis = new FileInputStream("Z:\\Check.zip");
			zis = new ZipInputStream(fis);
			entry = zis.getNextEntry();

			while ((entry = zis.getNextEntry()) != null)
			{
				String filePath = "Z:\\" + File.separator + entry.getName();

				if(!entry.isDirectory())
				{
					extractFiles(zis,filePath);
				}
				else
				{
					File nDir = new File(filePath);
					nDir.mkdir();
				}
				zis.closeEntry();
			}

			fis.close();
			zis.close();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void extractFiles(ZipInputStream zis,String filePath)
	{
		BufferedOutputStream bos = null;

		try
		{
			bos = new BufferedOutputStream( new FileOutputStream(filePath));
			byte bArr[] = new byte[256];

			while(zis.read(bArr) != -1)
			{
				bos.write(bArr);
			}
			bos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args)throws Exception
	{
		extractZipFile();
	}
}