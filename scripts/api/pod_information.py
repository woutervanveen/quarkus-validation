import requests


def main() -> None:
    url = "http://192.168.49.2/pod-info"
    data = {}
    for i in range(1, 100):
        response = requests.get(url).content.decode("utf-8")

        if response not in data.keys():
            data[response] = 1
        else:
            data[response] += 1

    for key in data.keys():
        print(f"pod {key} handled {data[key]} requests")


if __name__ == "__main__":
    main()
