package com.mobilepark.airtalk.service;

import com.mobilepark.airtalk.data.Group;
// import com.mobilepark.airtalk.data.Auth;
import com.mobilepark.airtalk.data.Menu;
import com.mobilepark.airtalk.repository.AuthGroupRepository;
// import com.mobilepark.airtalk.repository.AuthRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthGroupService {
    private static final Logger logger = LoggerFactory.getLogger(AuthGroupService.class);

    @Autowired
    AuthGroupRepository authGroupRepository;

    // @Autowired
    // AuthRepository AuthRepository;

    @Autowired
    MenuService menuService;

    public List<Group> search(){
        List<Group> list = new ArrayList<>();

        try {
            list = authGroupRepository.findAll();
        } catch(Exception e) {
            logger.error(e.getMessage());
        }

        return list;
    }

    // public Group findByAuthGroupSeq(int authGroupSeq){
    //     Group authGroup = authGroupRepository.nativeFindByAdminGroupSeq(adminGroupSeq);
    //     return authGroup;
    // }

    // public AdminGroup view(int adminGroupSeq) {
    //     try {
    //         Optional<AdminGroup> optionalAdminGroup = adminGroupRepository.findById(adminGroupSeq);

    //         if (!optionalAdminGroup.isPresent()) {
    //             return null;
    //         }

    //         return optionalAdminGroup.get();
    //     } catch (Exception e) {
    //         logger.error(e.getMessage());
    //         return null;
    //     }
    // }

    // public List<AdminGroupAuth> searchAdminGroupAuth(int adminGroupSeq) {
    //     List<AdminGroupAuth> adminGroupAuthList = new ArrayList<>();

    //     try {
    //         adminGroupAuthList = adminGroupAuthRepository.findByAdminGroupSeq(adminGroupSeq, new Sort(Sort.Direction.DESC, "seq"));
    //     } catch (Exception e) {
    //         logger.error(e.getMessage());
    //     }

    //     return adminGroupAuthList;
    // }

    @Transactional
    public Group create(String name, String description, String arrayAuth) {
        Group Group = null;
        // AuthGroup AuthGroup = null;
        JSONObject jsonObject = null;

        try {
            /* 그룹 등록 처리 START */
            Group = new Group();
            Group.setName(name);
            Group.setDescription(description);
            Group.setRegDate(new Date());

            //Group = authGroupRepository.save(Group);
            /* 그룹 등록 처리 END */

            /* 그룹 권한 등록 처리 START */
            // this.adminGroupAuthChange(adminGroup.getAdminGroupSeq(), arrayAuth);
            /* 그룹 권한 등록 처리 END */
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Group;
    }

    // @Transactional
    // public AdminGroup modify(Integer adminGroupSeq, String name, String description, String arrayAuth) {
    //     AdminGroup adminGroup = null;
    //     AdminGroupAuth adminGroupAuth = null;
    //     JSONObject jsonObject = null;

    //     try {
    //         /* 그룹 등록 처리 START */
    //         adminGroup = new AdminGroup();
    //         adminGroup.setAdminGroupSeq(adminGroupSeq);
    //         adminGroup.setName(name);
    //         adminGroup.setDescription(description);
    //         adminGroup.setModDate(new Date());

    //         adminGroup = adminGroupRepository.save(adminGroup);
    //         /* 그룹 등록 처리 END */

    //         /* 그룹 권한 등록 처리 START */
    //         this.adminGroupAuthChange(adminGroup.getAdminGroupSeq(), arrayAuth);
    //         /* 그룹 권한 등록 처리 END */
    //     } catch (Exception e) {
    //         logger.error(e.getMessage());
    //     }

    //     return adminGroup;
    // }

    // @Transactional
    // public void remove(int adminGroupSeq) {
    //     AdminGroup adminGroup = null;
    //     AdminGroupAuth adminGroupAuth = null;
    //     JSONObject jsonObject = null;

    //     try {
    //         /* 그룹 권한 삭제 처리 START */
    //         adminGroupAuthRepository.deleteAllByAdminGroupSeqEquals(adminGroupSeq);
    //         /* 그룹 권한 삭제 처리 END */

    //         /* 그룹 삭제 처리 START */
    //         adminGroupRepository.deleteById(adminGroupSeq);
    //         /* 그룹 삭제 처리 END */
    //     } catch (Exception e) {
    //         logger.error(e.getMessage());
    //     }
    // }

    // public List<AdminGroupAuth> getMenuAuthList(int adminGroupSeq) {
    //     List<AdminGroupAuth> adminGroupAuthList = new ArrayList<>();

    //     try {
    //         List<Menu> menuList = menuService.getMenuList();

    //         List<AdminGroupAuth> source = adminGroupAuthRepository.findByAdminGroupSeq(adminGroupSeq, new Sort(Sort.Direction.DESC, "seq"));

    //         Menu menu = null;
    //         for(int i=0; i<menuList.size(); i++) {
    //             menu = menuList.get(i);

    //             this.menuCheck(adminGroupAuthList, menu, source);
    //         }
    //     } catch (Exception e) {
    //         logger.error(e.getMessage());
    //     }

    //     return adminGroupAuthList;
    // }

    // private void menuCheck(List<AdminGroupAuth> target, Menu menu, List<AdminGroupAuth> source) {
    //     try {
    //         AdminGroupAuth adminGroupAuth = new AdminGroupAuth();
    //         String menuAuth = "N";

    //         for(int i=0; i<source.size(); i++) {
    //             if(menu.getMenuSeq() == source.get(i).getMenuSeq()) {
    //                 menuAuth = source.get(i).getAuth();

    //                 break;
    //             }
    //         }

    //         adminGroupAuth.setMenuSeq(menu.getMenuSeq());
    //         adminGroupAuth.setAuth(menuAuth);
    //         adminGroupAuth.setMenu(menu);

    //         target.add(adminGroupAuth);
    //     } catch(Exception e) {
    //         logger.error(e.getMessage());
    //     }
    // }

    // private void adminGroupAuthChange(Integer adminGroupSeq, String arrayAuth) {
    //     try {
    //         AdminGroupAuth adminGroupAuth = null;
    //         JSONObject jsonObject = null;
    //         JSONParser jsonParser = new JSONParser();
    //         JSONArray jsonArray = (JSONArray) jsonParser.parse(arrayAuth);

    //         for(int i=0; i<jsonArray.size(); i++) {
    //             jsonObject = (JSONObject)jsonArray.get(i);

    //             adminGroupAuth = new AdminGroupAuth();
    //             adminGroupAuth.setAdminGroupSeq(adminGroupSeq);
    //             adminGroupAuth.setMenuSeq(Integer.parseInt(jsonObject.get("menuSeq").toString()));
    //             adminGroupAuth.setAuth(jsonObject.get("auth").toString());
    //             adminGroupAuth.setRegDate(new Date());
    //             adminGroupAuth.setModDate(new Date());

    //             adminGroupAuthRepository.save(adminGroupAuth);
    //         }
    //     } catch (Exception e) {
    //         logger.error(e.getMessage());
    //     }
    // }
}