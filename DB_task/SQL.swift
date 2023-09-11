select t.nazwa, s.ilosc from sprzedaz s
left join dokument_sprzedazy ds on ds.id = s.dokument_sprzedy_id
inner join towar t on s.towar_id = t.id
where ds.data_wystawienia >= '2022-06-01' and ds.data_wystawienia < '2022-07-01';


select k.nazwa, t.nazwa, s.ilosc from sprzedaz s
join dokument_sprzedazy ds on ds.id = s.dokument_sprzedy_id
join towar t on s.towar_id = t.id
join typ_dokumentu_sprzedazy tds on ds.typ = tds.id
join kontrahent k on ds.kontrahent = k.id
where ds.data_wystawienia >= '2022-06-01' and ds.data_wystawienia < '2022-07-01'
and tds.nazwa = 'FAKTURA'
group by (k.nazwa, t.nazwa, s.ilosc);