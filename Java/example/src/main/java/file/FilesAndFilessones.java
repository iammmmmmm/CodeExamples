package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 *   读取指定文件下的所有文件及其子文件夹，根据文件类型进行过滤
 *@author Iammm
 *@date 2023/10/21 18:38
 */
public class FilesAndFilessones {
    private List<File> list;
    private String basePath = "D:\\code\\";
    private String type = "jar";
    private Logger logger = LoggerFactory.getLogger(FilesAndFilessones.class);

    public static void main(String[] args) {
        // 获取指定路径下的所有文件
        new FilesAndFilessones().getList("");
        // 获取指定路径下指定类型的文件
        new FilesAndFilessones().getListByType("D:\\code\\", "java");
        // 获取指定路径下指定类型的文件
        new FilesAndFilessones().getListByType("D:\\code\\", "json");
        // 获取指定路径下指定类型的文件
        new FilesAndFilessones().getListByType("D:\\code\\", "xml");
    }


    private boolean isNullOrEmpty(String basePath) {
        return basePath == null || basePath.isEmpty();
    }
    public List<File> getList(String basePath) {
        if (basePath == null || basePath.isEmpty()) {
            logger.info("basePath为空,使用默认路径{}", this.basePath);
        } else {
            this.basePath = basePath;
        }
        File dir = new File(this.basePath);
        if (!dir.exists()) {
            logger.error("{}不存在", basePath);
            return null;
        }
        list = new ArrayList<>();
        // 获取指定路径下的所有文件
        getAllFile(dir, list);
        logger.info("{}文件夹下共有{}个文件", basePath, list.size());
        return list;
    }

    public List<File> getListByType(String basePath, String type) {
        if (basePath == null || basePath.isEmpty()) {
            logger.info("basePath为空,使用默认路径{}", this.basePath);
        } else {
            this.basePath = basePath;
        }
        File dir = new File(this.basePath);
        if (!dir.exists()) {
            logger.error("{}不存在", basePath);
            return null;
        }
        list = new ArrayList<>();
        // 获取指定路径下指定类型的文件
        getAllFilesByType(dir, list, type);
        logger.info("{}文件夹下共有{}个{}文件", basePath, list.size(), type);
        return list;
    }

    /**
     * 获取所有文件
     * @param dir 文件路径
     * @param list 文件列表
     */
    private void getAllFile(File dir, List<File> list) {
        // 获取文件列表
        File[] fileList = dir.listFiles();
        if (fileList == null) {
            logger.error("{}文件夹下没有文件", dir.getName());
            return;
        }
        for (File file : fileList) {
            if (file.isDirectory()) {
                // 递归处理文件夹
                getAllFile(file, list);
            } else {
                // 如果是文件则将其加入到文件数组中
                list.add(file);
            }
        }
    }

    private void getAllFilesByType(File dir, List<File> list, String type) {
        // 获取文件列表
        File[] fileList = dir.listFiles();
        if (fileList == null) {
            logger.error("{}文件夹下没有文件", dir.getName());
            return;
        }
        for (File file : fileList) {
            if (file.isDirectory()) {
                // 递归处理文件夹
                getAllFilesByType(file, list, type);
            } else {
                // 如果是文件则将其加入到文件数组中
                if (file.getName().endsWith(type)) {
                    logger.debug(file.getName());
                    list.add(file);
                }
            }
        }
    }
}
