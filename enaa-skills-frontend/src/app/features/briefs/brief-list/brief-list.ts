import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BriefService } from '../brief.service';

@Component({
  selector: 'app-brief-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './brief-list.html',
  styleUrls: ['./brief-list.css']
})
export class BriefList implements OnInit {
  briefs: any[] = [];

  constructor(private briefService: BriefService) {}

  ngOnInit(): void {
    this.briefService.getBriefs().subscribe(data => {
      this.briefs = data;
    });
  }

  deleteBrief(id: number): void {
    this.briefService.deleteBrief(id).subscribe(() => {
      this.briefs = this.briefs.filter(brief => brief.id !== id);
    });
  }
}