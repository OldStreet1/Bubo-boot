import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/bubo";


export function commonRequestGet(url,query) {
  if (!url){
    return null;
  }
  return request({
    url: url,
    method: 'get',
    params: query
  })
}


export function commonRequestPost(url,query) {

  if (!url){
    return null;
  }
  return request({
    url: url,
    method: 'post',
    params: query
  })
}
