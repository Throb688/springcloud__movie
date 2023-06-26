export interface SessionInt{
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


export class SessionData{
  tableData:SessionInt[]=[]
  movieList:ListInt[]=[]
  dialogFormVisible=false
  formLabelWidth = '140px'
  form:SessionInt = {
    sessionid:0,
    movieid:"",
    site:"",
    time:"",
    status:1
  }
}
