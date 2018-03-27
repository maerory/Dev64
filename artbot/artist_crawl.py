import scrapy, sys, json
from scrapy.crawler import CrawlerProcess

def read_in():
    lines = sys.stdin.readlines()
    return json.loads(lines[0])

def main():

    input_url = read_in()

    class ArtistBioSpider(scrapy.Spider):
        name = "artistbio"
        start_urls = [
            'http://www.mutualart.com' + input_url,
        ]

        def parse(self, response):
            name = (response.css('h1.name::text').extract_first()).strip()
            bio = response.css('p.desc').extract_first()
            if bio is not None:
                bio = bio.split('\r\n')
                nationality = bio[1].strip()
                if len(bio) > 2:
                    years = bio[-2].strip()
                else:
                    years = None
            else:
                nationality = years = None
            art_link = response.css('div.img-block img::attr(src)').extract_first()
            art_title = response.css('div.text-block::text').extract_first()

            request_artist_json = {
                'name': name,
                'nationality': nationality,
                'years': years,
                'art_title': art_title,
                'art_link': art_link,
            }
            print request_artist_json
            return request_artist_json

    process = CrawlerProcess({
        'USER_AGENT': 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)'
    })
    process.crawl(ArtistBioSpider)
    process.start()

if __name__ == '__main__':
    main()
