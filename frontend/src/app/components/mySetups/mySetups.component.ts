import {Component, inject} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SetupValues} from "../../model/setup/setup-values";
import {RequestService} from "../../service/request.service";

@Component({
  selector: 'app-user',
  templateUrl: './mySetups.component.html',
  styleUrls: ['./mySetups.component.css']
})
export class MySetupsComponent {

  setupList: Array<SetupValues>;

  constructor(private requestService: RequestService) {

    this.requestService.getCustomSetupsByUserId(Number(localStorage.getItem("userId")))
      .subscribe((data: any) => {
        this.setupList = data;
      })
  }
}
