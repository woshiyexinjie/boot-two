####根据官网的demo 可能的误解
因为官网写了这么一句话：   
This is all you actually need to build a working GraphQL API. After the starting the Spring Boot application 
the API is available on http://localhost:8080/graphql.   
但是我们直接访问以上网址，你会发现后台   
2020-08-19 16:53:10.864  WARN 55883 --- [nio-8080-exec-8] .w.s.m.s.DefaultHandlerExceptionResolver : 
Resolved [org.springframework.web.bind.MissingServletRequestParameterException: Required String parameter 'query' is not present]   

所以实际上 你可以访问
http://localhost:8080/graphql?query={
bookById(id: "book-1"){
id
name
pageCount
author {
firstName
lastName
}
}
}
如果浏览器失败，可能是编码什么的。尝试postman等工具！

