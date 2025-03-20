import { Injectable } from '@angular/core';
import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest
} from '@angular/common/http';

import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';

/** Pass untouched request through to the next request handler. */
@Injectable()
export class ApiInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
    const apiUrl = req.clone({url: environment.apiUrl + req.url})
    return next.handle(apiUrl);
  }
}