package com.it.controller;

import com.it.utils.FastDFSClientUtils;
import com.it.utils.ResultCode;
import com.it.utils.ResultCommon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImgUploadController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    @ResponseBody
    @RequestMapping("/image_upload")
    public ResultCommon ImageUpload(MultipartFile file){
        //获取上传照片名
        String originalFilename = file.getOriginalFilename();
        //截取照片后缀名
        String suffixFilename = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        try {
            //获取工具类,配置文件
            FastDFSClientUtils fastDFSClientUtils = new FastDFSClientUtils("classpath:config/fdfs_client.conf");

            String url = fastDFSClientUtils.uploadFile(file.getBytes(), suffixFilename);

            String fullPath=FILE_SERVER_URL+url;

            return ResultCommon.success(ResultCode.SUCCESS,fullPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ResultCommon.fail(ResultCode.FAIL);
    }
}
