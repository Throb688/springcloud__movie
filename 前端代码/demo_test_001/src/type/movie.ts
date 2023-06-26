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

export interface SessionInt{
  sessionid:number;
  movieid:string;
  site:string;
  time:string;
  status:string;
}

export interface UploadParams {
  file: File;
}

export interface CommentsInt{
  evaluateid:number;
  username:string;
  evaluatetext:string;
  evaluatetime:string
}

export class InitData{
  list:ListInt[]=[]
  ruleForm:ListInt={
    movieid:"",
    title:"",
    director:"",
    actors:"",
    releasedate:"",
    description:"",
    genres:"",
    durationminutes:0,
    posterurl:"",
    duration:"",
    price:""
  }
  sessionList:SessionInt[]=[]
  sesssionFrom:SessionInt={
    sessionid:0,
    movieid:"",
    site:"",
    time:"",
    status:""
  }
  dialogFormVisible = false
  list1:SessionInt[]=[]
  comments:CommentsInt[] = []
}

interface selectDataInt{
  title:string,
  introduce:string,
  page:number,
  count:number,
  pagesize:number
}


export class BackData{
  tableData:ListInt[]=[]
  form:ListInt={
    movieid:"",
    title:"",
    director:"",
    actors:"",
    releasedate:"",
    description:"",
    genres:"",
    durationminutes:3,
    posterurl:"",
    duration:"",
    price:""
  }
  dialogFormVisible = false
  selectData:selectDataInt={
    title:"",
    introduce:"",
    page:1,
    count:0,
    pagesize:4,
}
}

