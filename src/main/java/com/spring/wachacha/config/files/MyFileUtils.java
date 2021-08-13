package com.spring.wachacha.config.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
public class MyFileUtils {

    @Value("${spring.servlet.multipart.location}") // 추가할것
    private String uploadFilePath;

    // make folder
    public boolean makeFolders(String path) {
        File folder = new File(path);
        return folder.mkdirs();
    }

    // make save path
    public String getSavePath(String path) {
        return uploadFilePath + "/" + path;
    }

    // make random file name
    public String getRandomFileNm() {
        return UUID.randomUUID().toString();
    }

    // make random file name(with ext)
    public String getRandomFileNm(String originNm) {
        return getRandomFileNm() + "." + getExt(originNm);
    }

    // make random file name(first)
    public String getRandomFileNm(MultipartFile file) {
        return getRandomFileNm(file.getOriginalFilename());
    }

    // get ext
    public String getExt(String fileNm) {
        return fileNm.substring(fileNm.lastIndexOf(".") + 1);
    }

    // save file & return random file name
    public String transferTo(MultipartFile mf, String target) { // target(ex) : "profile/userPk"
        String fileNm = getRandomFileNm(mf);
        String basePath = getSavePath(target);
        makeFolders(basePath);
        File originDir = new File(basePath);
        if( originDir.exists() ){ //파일존재여부확인

            if(originDir.isDirectory()){ //파일이 디렉토리인지 확인

                File[] files = originDir.listFiles();

                for( int i=0; i<files.length; i++){
                    if( files[i].delete() ){
                        System.out.println(files[i].getName()+" 삭제성공");
                    }else{
                        System.out.println(files[i].getName()+" 삭제실패");
                    }
                }
            }
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }
        File saveFile = new File(basePath, fileNm);
        try{
            mf.transferTo(saveFile);
            return fileNm;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
