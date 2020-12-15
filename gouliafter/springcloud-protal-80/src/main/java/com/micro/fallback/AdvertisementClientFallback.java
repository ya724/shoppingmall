package com.micro.fallback;

import com.micro.api.AdvertisementClient;
import com.micro.pojo.Advertisement;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: MicroService
 * @BelongsPackage: com.micro.fallback
 * @CreateTime: 2020-11-20 16:30
 * @Description: 广告降级   解耦合
 */
@Component
public class AdvertisementClientFallback implements FallbackFactory<AdvertisementClient> {

    @Override
    public AdvertisementClient create(Throwable throwable) {
       return new AdvertisementClient() {
           /**
            * 降级的方法
            * @param category_id
            * @return
            */
           @Override
           public List<Advertisement> findAdvertisementsBycategory_id(Integer category_id) {
               System.out.println("广告服务降级...");
               List<Advertisement> advertisements=new ArrayList<>();
               if(category_id.toString().equals("1")){
                   advertisements.add(new Advertisement(1,1,"我是广告","/product_cate/1","https://img14.360buyimg.com/pop/s1180x940_jfs/t1/122621/34/18212/79353/5fabb22cEb8c94c12/01446a4c59e62dbe.jpg","1",1,0));
               }else if(category_id.toString().equals("2")){
                   advertisements.add(new Advertisement(1,1,"我是广告","/product_cate/1","https://img12.360buyimg.com/n7/jfs/t1/131230/11/6656/101246/5f32857bE04845102/d8d5f1801d607817.jpg","1",1,0));
               }else {
                   advertisements.add(new Advertisement(1,1,"我是广告","/product_cate/1","https://img11.360buyimg.com/n7/jfs/t1/145842/5/7994/120006/5f582e3dE7b2add78/fd8a28d3cd31422e.jpg","1",1,0));
               }
               return advertisements;
           }

       };
    }

}
