 export interface Order {
  id: string;
  info: string;
  quantity: string;
  totalPrice: number;
  shippingAddress: string;
  movieid:number,
  session:number
}

export interface OrderInt{
  orderid:string;
  sessionid:number;
  seatidInfo:string[];
  seatInfo:string;
  price:number;
  userid:number;
}

export interface OrderInt1{
  orderid:string;
  sessionid:number;
  seatidInfo:string;
  seatInfo:string;
  price:number;
  userid:number;
}



export class OrdertData{
  order:Order={
    id: '123',
    info: 'Example Product',
    quantity: "",
    totalPrice: 100,
    shippingAddress: '123 Shipping Street, City',
    movieid:0,
    session:0
  }
  seatList:string[] = []
  sesssionFrom:OrderInt={
    orderid:"",
    sessionid:0,
    seatidInfo:[],
    seatInfo:"",
    price:0,
    userid:Number(localStorage.getItem("token")+""),
  }
}

export interface OrderListInt{
  orderid:string;
  sessionid:number;
  seatidInfo:string[];
  seatinfo:string;
  price:number;
  userid:number;
  ordertime:string
}


export class OrdertInit{
  OrderList:OrderListInt[]=[]
  dialogFormVisible=false
  title =""
}

export class OrdertList{
  tableData:OrderInt1[]=[]
}

