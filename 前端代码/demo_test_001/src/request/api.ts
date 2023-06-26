import service from ".";
interface loginData{
    username:string,
    password:string
}
interface SessionInt{
    sessionid:number,
    movieid:string,
    site:string,
    time:string,
    status:number
  }

export interface ListInt{
    movieid:string
    title:string
    director:string
    actors:string
    releasedate:string
    description:string
    genres:string
    durationminutes:number
    posterurl:string
    duration:string
    price:string
}

interface OrderInt{
    orderid:string;
    sessionid:number;
    seatidInfo:string[];
    seatInfo:string;
    price:number;
    userid:number
}

interface EvaluateDto{
    evaluatetext:string;
    userid:number;
    movieId:number;
}
  

export function login(data:loginData){
    return service({
        url:'/user/userconsumer/login',
        method:'post',
        data
    })
}

export function register(data:loginData){
    return service({
        url:'/user/userconsumer/registration',
        method:'post',
        data
    })
}

export function userList(){
    return service({
        url:'/user/userconsumer/',
        method:'get',
    })
}

export function getMovieList(){
    return service({
        url:'/movie/movieconsumer/',
        method:'get',
    })
}

export function addMovie(data:ListInt){
    return service({
        url:'/movie/movieconsumer/addMovie',
        method:'post',
        data,
    })
}

export function updateMovie(data:ListInt){
    return service({
        url:'/movie/movieconsumer/updateMovie',
        method:'post',
        data,
    })
}

export function delMovie(data:number){
    return service({
        url:'/movie/movieconsumer/delMovie/'+data,
        method:'get',
    })
}

export function getMovieListById(id:number){
    return service({
        url:'/movie/movieconsumer/getMovieListById/'+id,
        method:'get',
    })
}

export function findMovie(data:string){
    return service({
        url:'/movie/movieconsumer/findMovie/'+data,
        method:'get',
    })
}

export function findEvaluate(movie:number){
    return service({
        url:'/user/userconsumer/findEvaluate/'+movie,
        method:'get',
    })
}

export function addEvaluate(data:EvaluateDto){
    return service({
        url:'/user/userconsumer/addEvaluate/',
        method:'post',
        data
    })
}


export function getSession(){
    return service({
        url:'/session/sessionconsumer/',
        method:'get',
    })
}


export function addSession(data:SessionInt){
    return service({
        url:'/session/sessionconsumer/addSession/',
        method:'post',
        data
    })
}

export function delSession(id:number){
    return service({
        url:'/session/sessionconsumer/delSession/'+id,
        method:'get',
    })
}

export function getSessionList(id:number){
    return service({
        url:'/session/sessionconsumer/getSessionList/'+id,
        method:'get',
    })
}

export function getSessionListById(id:number){
    return service({
        url:'/session/sessionconsumer/getSessionListById/'+id,
        method:'get',
    })
}   

export function getAuthorityList(){
    return service({
        url:'/getAuthorityList',
        method:'get',
    })
}

export function getSeatList(){
    return service({
        url:'/seat/seatconsumer/getSeatList',
        method:'get',
    })
}

export function getSeatListById(id:string[]){
    return service({
        url:'/seat/seatconsumer/getSeatListById/'+id,
        method:'get',
    })
}


export function addOrder(data:OrderInt){
    return service({
        url:'/order/orderconsumer/addOrder',
        method:'post',
        data
    })
}

export function orderList(){
    return service({
        url:'/order/orderconsumer/',
        method:'get',
    })
}

export function findOrderByUserId(id:number){
    return service({
        url:'/order/orderconsumer/findOrderByUserId/'+id,
        method:'get',
    })
}

export function findSessionById(id:number){
    return service({
        url:'/order/orderconsumer/findSessionById/'+id,
        method:'get',
    })
}

