/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wentch.redkale.net.socks;

import com.wentch.redkale.net.*;
import com.wentch.redkale.util.*;
import java.util.concurrent.atomic.*;

/**
 *
 * @author zhangjx
 */
public class SocksResponse extends Response<SocksRequest> {

    protected SocksResponse(Context context, SocksRequest request) {
        super(context, request);
    }
    
    public static ObjectPool<Response> createPool(AtomicLong creatCounter, AtomicLong cycleCounter, int max, Creator<Response> creator) {
        return new ObjectPool<>(creatCounter, cycleCounter, max, creator, (x) -> ((SocksResponse) x).prepare(), (x) -> ((SocksResponse) x).recycle());
    }
}
