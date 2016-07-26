package vote.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import vote.com.vo.VoteFile;


@Component("fileUtils")
public class FileUtils {
	private static final String filePath = "/Users/Soyoun/Documents/files/";
    
    public List<VoteFile> parseInsertFileInfo(int articleNo, HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
         
        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;
         
        List<VoteFile> list = new ArrayList<VoteFile>();
         
        File file = new File(filePath);
        if(file.exists() == false){
            file.mkdirs();
        }
         
        while(iterator.hasNext()){
            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            if(multipartFile.isEmpty() == false){
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = CommonUtils.getRandomString() + originalFileExtension;
                 
                file = new File(filePath + storedFileName);
                multipartFile.transferTo(file);
                
                VoteFile voteFile = new VoteFile()
                		.setArticleNo(articleNo)
                		.setOriginalFileName(originalFileName)
                		.setStoredFileName(storedFileName)
                		.setFileSize(multipartFile.getSize());
                list.add(voteFile);
            }
        }
        return list;
    }
}
