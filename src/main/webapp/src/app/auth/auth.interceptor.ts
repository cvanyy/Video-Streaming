import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {HttpInterceptor, HttpRequest, HttpHandler, HttpEvent} from "@angular/common/http";
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/do';

@Injectable()
export class AuthInterceptor {

  constructor(private router: Router) { }

  // intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  //   // if (req.headers.get('No-Auth') == "True")
  //   //   return next.handle(req.clone());
  //
  //   if (localStorage.getItem('userToken') != null) {
  //     const clonedreq = req.clone({
  //       headers: req.headers.set("Authorization", "Bearer " + localStorage.getItem('userToken'))
  //     });
  //     return next.handle(clonedreq)
  //       .do(
  //         succ => { },
  //         err => {
  //           if (err.status === 401)
  //             this.router.navigateByUrl('/login');
  //         }
  //       );
  //   } else {
  //       this.router.navigateByUrl('/login');
  //     }
  //   }

}
