import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpClientWrapper {

  constructor(private http: HttpClient) {}

  createOptions() {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${localStorage.getItem('token')}`
      }),
    };
  }

  get(url: string): Observable<any> {
    return this.http.get(url, this.createOptions())
  }

  post(url: string, data:any): Observable<any> {
    return this.http.post(url, data, this.createOptions())
  }

  postWithoutHeaders(url: string, data:any): Observable<any> {
    return this.http.post(url, data)
  }

  put(url: string, data: any):Observable<any> {
    return this.http.put(url, data, this.createOptions())
  }
}
