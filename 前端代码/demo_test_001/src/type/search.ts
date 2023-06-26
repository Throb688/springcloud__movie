export interface SearchResult {
  movieid:string;
  title:string;
  director:string;
  genres:string;
  posterurl:string;
  duration:string;
  price:string;
}


export class InitData{
  searchresult:SearchResult[]=[]
  showResults=false
}
