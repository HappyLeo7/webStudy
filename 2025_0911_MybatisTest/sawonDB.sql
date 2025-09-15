select sahire from sawon
where substr(sahire,1,2) >= 90 

select sahire from sawon
where substr(sahire,1,2) >= 80 and 90 < substr(sahire,1,2)




select sahire from sawon
where concat(substr(to_char(sahire,'YYYY'),1,3),'0')=1990
select sahire from sawon
where concat(substr(to_char(sahire,'YYYY'),1,3),'0')=2000
select sahire from sawon
where concat(substr(to_char(sahire,'YYYY'),1,3),'0')=2000
select sahire from sawon
where concat(substr(to_char(sahire,'YYYY'),1,3),'0')=1980




select substr(sahire,1,2) from sawon

select * from visit