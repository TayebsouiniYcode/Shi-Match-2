import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor() {}


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("this is interceptor");
    const token = localStorage.getItem("token");
    console.log(token);
    if (token) {
      console.log("this is if" + token);
      const cloned  = request.clone({
        headers: request.headers.set("Authorization", `Bearer ${token}`)
      });
      console.log(cloned);
      return next.handle(cloned);
    }

    return next.handle(request);
  }
}