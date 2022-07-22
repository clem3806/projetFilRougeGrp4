import { Component, OnInit } from '@angular/core';
import { Formations } from 'src/app/interfaces/formations';
import { FormationsService } from 'src/app/services/formations.service';

@Component({
  selector: 'app-formations',
  templateUrl: './formations.component.html',
  styleUrls: ['./formations.component.css']
})
export class FormationsComponent implements OnInit {
  
  formations: Formations[] = [];

  constructor(private fs: FormationsService) { }

  ngOnInit(): void {
    this.initFormations();
  }

  initFormations() {
    this.fs.getAllFormations().subscribe((res: Formations[]) => {
      this.formations = res;
    });
  }

}
