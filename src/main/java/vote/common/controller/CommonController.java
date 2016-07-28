package vote.common.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vote.com.util.Constant;
import vote.com.vo.VoteFile;
import vote.common.service.CommonService;

@Controller
public class CommonController {
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="commonService")
    private CommonService commonService;
    
    @RequestMapping(value="/common/getImageFile.do")
    public void downloadFile(@RequestParam("fileno") int fileno, HttpServletResponse response) throws Exception{
        VoteFile votefile = commonService.selectFileInfo(fileno);
        String storedFileName = votefile.getStoredFileName();
        String ext = null;
        String type = null;
        
        // 확장자 확인
        int index = storedFileName.lastIndexOf(".");
        if (index != -1) {
            ext = storedFileName.substring(index + 1);
        }
        
        byte fileByte[] = FileUtils.readFileToByteArray(new File(new Constant().filePath + storedFileName));
        if ("jpg".equals(ext)) { 
        	type = "image/jpeg"; 
        } else { 
            type = "image/" + ext.toLowerCase(); 
        }
        
        response.setContentType(type);
        response.setContentLength(fileByte.length);
//        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
//        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileByte);
        
         
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

}