import { Component, OnInit, Input } from '@angular/core';
import { LoggingService } from '../shared/logging.service';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
  providers: [LoggingService]
})
export class HomepageComponent implements OnInit {

  

  constructor(private loggingService: LoggingService) { }

  ngOnInit(): void {
  }

}
