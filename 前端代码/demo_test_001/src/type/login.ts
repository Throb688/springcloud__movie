export interface LoginFromInt{
    username:string
    password:string
}

export class LoginData{
    ruleForm:LoginFromInt={
        username:"",
        password:""
    }
}

export interface User{
    id:number,
    username:string,
    registrationdate:string
}

export class UserList{
    tableData:User[]=[]
}