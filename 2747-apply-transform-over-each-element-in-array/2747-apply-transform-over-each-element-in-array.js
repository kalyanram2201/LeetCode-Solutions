/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const list=[];
    let id=0;
    for(const key of arr){
        list[id]=fn(key,id);
        id++;
    }
    return list;
};